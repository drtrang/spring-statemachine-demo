package com.github.trang.statemachine.config;

import com.github.trang.statemachine.model.enums.EnumHousedelStatus;
import com.github.trang.statemachine.model.enums.Events;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author trang
 */
@Configuration
@Slf4j
public class StateMachineConfig {

    @Configuration
    @EnableStateMachine
    static class PersistStateMachineConfig extends StateMachineConfigurerAdapter<String, String> {

        @Autowired
        private StateMachineListener<String, String> stateMachineListener;

        /**
         * 初始化状态机
         */
        @Override
        public void configure(StateMachineStateConfigurer<String, String> config) throws Exception {
            config.withStates()
                    .initial(EnumHousedelStatus.VALID.getState())
                    .states(
                            EnumSet.allOf(EnumHousedelStatus.class).stream()
                                    .map(EnumHousedelStatus::getState)
                                    .collect(Collectors.toSet())
                    );
        }

        /**
         * 配置状态转换
         */
        @Override
        public void configure(StateMachineTransitionConfigurer<String, String> transitions) throws Exception {
            transitions
                    .withExternal()
                    .event(Events.INTENTION)
                    .source(EnumHousedelStatus.VALID.getState())
                    .target(EnumHousedelStatus.DRAFT_INTENTION.getState())
                    .and()
                    .withExternal()
                    .event(Events.PAY)
                    .source(EnumHousedelStatus.DRAFT_INTENTION.getState())
                    .target(EnumHousedelStatus.DRAFT_EARNEST.getState())
                    .and()
                    .withExternal()
                    .event(Events.CONTRACT)
                    .source(EnumHousedelStatus.DRAFT_EARNEST.getState())
                    .target(EnumHousedelStatus.DRAFT.getState())
                    .and()
                    .withExternal()
                    .event(Events.TRANSFER)
                    .source(EnumHousedelStatus.DRAFT.getState())
                    .target(EnumHousedelStatus.TRANSFER.getState())
            ;
        }

        @Override
        public void configure(StateMachineConfigurationConfigurer<String, String> config) throws Exception {
            config.withConfiguration()
                    .machineId("state-machine-test")
                    .autoStartup(true)
                    .listener(stateMachineListener);
        }

        @Bean
        public StateMachineListener<String, String> stateMachineListener() {
            return new StateMachineListenerAdapter<String, String>() {
                @Override
                public void stateChanged(State<String, String> from, State<String, String> to) {
                    Optional.ofNullable(from).ifPresent(
                            (f) -> System.out.println("房源状态从 " + from.getId() + " 流转到 " + to.getId())
                    );
                }
            };
        }
    }

    @Configuration
    static class PersistHandlerConfig {

        @Bean
        public PersistStateMachineHandler persistStateMachineHandler(StateMachine<String, String> stateMachine) {
            return new PersistStateMachineHandler(stateMachine);
        }

        @Bean
        public Persist persist(PersistStateMachineHandler handler) {
            return new Persist(handler);
        }

    }

}
