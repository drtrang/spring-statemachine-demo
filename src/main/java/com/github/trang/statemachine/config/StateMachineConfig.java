package com.github.trang.statemachine.config;

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
    static class Config extends EnumStateMachineConfigurerAdapter<States, Events> {

        @Autowired
        StateMachineListener<States, Events> stateMachineListener;

        /**
         * 初始化状态机
         */
        @Override
        public void configure(StateMachineStateConfigurer<States, Events> config) throws Exception {
            config
                    .withStates()
                    .initial(States.S0)
                    .states(EnumSet.allOf(States.class));
        }

        /**
         * 配置状态转换
         */
        @Override
        public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
            transitions
                    .withExternal()
                        .source(States.S0).target(States.S1).event(Events.E0_1)
                        .and()
                    .withExternal()
                        .source(States.S1).target(States.S2).event(Events.E1_2)
                        .and()
                    .withExternal()
                        .source(States.S1).target(States.S3).event(Events.E1_3)
                        .and()
                    .withExternal()
                        .source(States.S2).target(States.S3).event(Events.E2_3);
        }

        @Override
        public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
            config.withConfiguration()
                    .machineId("state-machine-test")
                    .autoStartup(true)
                    .listener(stateMachineListener);
        }

        @Bean
        public StateMachineListener<States, Events> stateMachineListener() {
            return new StateMachineListenerAdapter<States, Events>() {
                @Override
                public void stateChanged(State<States, Events> from, State<States, Events> to) {
                    Optional.ofNullable(from).ifPresent(
                            (f) -> System.out.println("状态从 " + from.getId() + " 流转到 " + to.getId())
                    );
                }
            };
        }
    }

    public enum Events {
        E0_1, E1_2, E1_3, E2_3
    }

    public enum States {
        S0, S1, S2, S3, S4, S5, S6, S7
    }

}
