package com.github.trang.statemachine.config;

import com.github.trang.statemachine.model.domain.Housedel;
import com.github.trang.statemachine.model.enums.EnumHousedelStatus;
import com.github.trang.statemachine.model.enums.Events;
import com.github.trang.statemachine.service.HousedelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler.PersistStateChangeListener;
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
    static class Config extends StateMachineConfigurerAdapter<String, String> {

        @Autowired
        StateMachineListener<String, String> stateMachineListener;

        /**
         * 初始化状态机
         */
        @Override
        public void configure(StateMachineStateConfigurer<String, String> config) throws Exception {
            config
                    .withStates()
                    .initial(EnumHousedelStatus.VALID.getValue())
                    .states(EnumSet.allOf(EnumHousedelStatus.class).stream().map(EnumHousedelStatus::name).collect(Collectors.toSet()))
                    .end(EnumHousedelStatus.INVALID.getValue());
        }

        /**
         * 配置状态转换
         */
        @Override
        public void configure(StateMachineTransitionConfigurer<String, String> transitions) throws Exception {
            transitions
                    .withExternal().event(Events.E1_8.name()).source(EnumHousedelStatus.VALID.getValue()).target(EnumHousedelStatus.DRAFT_INTENTION.getValue())
                    .and()
                    .withExternal().event(Events.E8_9.name()).source(EnumHousedelStatus.DRAFT_INTENTION.getValue()).target(EnumHousedelStatus.SEAL_INTENTION.getValue())
                    .and()
                    .withExternal().event(Events.E9_10.name()).source(EnumHousedelStatus.SEAL_INTENTION.getValue()).target(EnumHousedelStatus.SIGN_INTENTION.getValue())
                    .and()
                    .withExit().target(EnumHousedelStatus.INVALID.getValue());
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

        @Autowired
        private HousedelService housedelService;

        @Bean
        public PersistStateMachineHandler persistStateMachineHandler(StateMachine<String, String> stateMachine) {
            return new PersistStateMachineHandler(stateMachine);
        }

        @Bean
        public PersistStateChangeListener persistStateChangeListener() {
            return (state, message, transition, stateMachine) ->
                    Optional.ofNullable(message)
                            .map(Message::getHeaders)
                            .filter(m -> m.containsKey("housedel"))
                            .map(m -> m.get("housedel", Housedel.class))
                            .map(Housedel::getHousedelCode)
                            .map(id -> Housedel.builder().housedelCode(id).delStatus(0).build())
                            .ifPresent(del -> housedelService.update(del));
        }

        @Bean
        public Persist persist(PersistStateMachineHandler handler, PersistStateChangeListener listener) {
            return Persist.builder()
                    .handler(handler)
                    .listener(listener)
                    .build();
        }
    }

}
