package com.github.trang.statemachine.annotation;

import com.github.trang.statemachine.config.Persist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.github.trang.statemachine.annotation.StateMachineConfig.Event.*;
import static com.github.trang.statemachine.annotation.StateMachineConfig.State.*;

/**
 * @author trang
 */
@Configuration
public class StateMachineConfig {

    @Configuration
    @EnableStateMachine
    static class PersistStateMachineConfig extends StateMachineConfigurerAdapter<String, String> {

        @Autowired
        private StateMachineListener<String, String> stateMachineListener;

        @Override
        public void configure(StateMachineStateConfigurer<String, String> states)
                throws Exception {
            states.withStates()
                    .initial(PLACED.getState())
                    .state(PROCESSING.getState())
                    .state(SENT.getState())
                    .state(DELIVERED.getState());
        }

        @Override
        public void configure(StateMachineTransitionConfigurer<String, String> transitions)
                throws Exception {
            transitions
                    .withExternal().event(PROCESS).source(PLACED.getState()).target(PROCESSING.getState())
                    .and()
                    .withExternal().event(SEND).source(PROCESSING.getState()).target(SENT.getState())
                    .and()
                    .withExternal().event(DELIVER).source(SENT.getState()).target(DELIVERED.getState());
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
                public void stateChanged(org.springframework.statemachine.state.State<String, String> from, org.springframework.statemachine.state.State<String, String> to) {
                    Optional.ofNullable(from).ifPresent(
                            (f) -> System.out.println("状态从 " + from.getId() + " 流转到 " + to.getId())
                    );
                }
            };
        }
    }

    @Configuration
    static class PersistHandlerConfig {

        @Autowired
        private StateMachine<String, String> stateMachine;

        @Bean
        public Persist persist() {
            return new Persist(persistStateMachineHandler());
        }

        @Bean
        public PersistStateMachineHandler persistStateMachineHandler() {
            return new PersistStateMachineHandler(stateMachine);
        }

    }

    @Data
    @AllArgsConstructor
    public static class Order {
        private int id;
        private int state;
    }

    public static class Event {
        public static final String PROCESS = "PROCESS";
        public static final String SEND = "SEND";
        public static final String DELIVER = "DELIVER";
        public static final String TEST = "TEST";
    }

    @AllArgsConstructor
    @Getter
    public enum State {
        PLACED("PLACED", 1),
        PROCESSING("PROCESSING", 2),
        SENT("SENT", 3),
        DELIVERED("DELIVERED", 4),
        ;

        private String state;
        private int status;

        private static final Map<String, Integer> STATE_MAP = new HashMap<>();
        private static final Map<Integer, String> STATUS_MAP = new HashMap<>();
        static {
            Arrays.stream(values()).forEach(e -> {
                STATE_MAP.put(e.getState(), e.getStatus());
                STATUS_MAP.put(e.getStatus(), e.getState());
            });
        }

        public static Integer getStatus(String state) {
            return STATE_MAP.get(state);
        }
        public static String getState(Integer status) {
            return STATUS_MAP.get(status);
        }
    }

}