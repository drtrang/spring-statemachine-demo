package com.github.trang.statemachine.config;

import com.github.trang.statemachine.model.enums.EnumHousedelStatus;
import com.github.trang.statemachine.model.enums.Events;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;
import java.util.Optional;

/**
 * @author trang
 */
@Configuration
@Slf4j
public class StateMachineConfig {

    @Configuration
    @EnableStateMachine
    static class Config extends EnumStateMachineConfigurerAdapter<EnumHousedelStatus, Events> {

        @Autowired
        StateMachineListener<EnumHousedelStatus, Events> stateMachineListener;

        /**
         * 初始化状态机
         */
        @Override
        public void configure(StateMachineStateConfigurer<EnumHousedelStatus, Events> config) throws Exception {
            config
                    .withStates()
                    .initial(EnumHousedelStatus.VALID)
                    .states(EnumSet.allOf(EnumHousedelStatus.class));
        }

        /**
         * 配置状态转换
         */
        @Override
        public void configure(StateMachineTransitionConfigurer<EnumHousedelStatus, Events> transitions) throws Exception {
            transitions
                    .withExternal().event(Events.意向金起草).source(EnumHousedelStatus.VALID).target(EnumHousedelStatus.DRAFT_INTENTION)
                    .and()
                    .withExternal().event(Events.意向金盖章).source(EnumHousedelStatus.DRAFT_INTENTION).target(EnumHousedelStatus.SEAL_INTENTION)
                    .and()
                    .withExternal().event(Events.意向金签订).source(EnumHousedelStatus.SEAL_INTENTION).target(EnumHousedelStatus.SIGN_INTENTION);
        }

        @Override
        public void configure(StateMachineConfigurationConfigurer<EnumHousedelStatus, Events> config) throws Exception {
            config.withConfiguration()
                    .machineId("state-machine-test")
                    .autoStartup(true)
                    .listener(stateMachineListener);
        }

        @Bean
        public StateMachineListener<EnumHousedelStatus, Events> stateMachineListener() {
            return new StateMachineListenerAdapter<EnumHousedelStatus, Events>() {
                @Override
                public void stateChanged(State<EnumHousedelStatus, Events> from, State<EnumHousedelStatus, Events> to) {
                    Optional.ofNullable(from).ifPresent(
                            (f) -> System.out.println("房源状态从 " + from.getId().getDesc() + " 流转到 " + to.getId().getDesc())
                    );
                }
            };
        }
    }

}
