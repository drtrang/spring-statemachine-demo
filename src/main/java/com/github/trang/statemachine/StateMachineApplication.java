package com.github.trang.statemachine;

import com.github.trang.statemachine.config.Persist;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;

import java.io.IOException;

import static com.github.trang.statemachine.StateMachineApplication.Event.*;
import static com.github.trang.statemachine.StateMachineApplication.STATE.*;

@SpringBootApplication
public class StateMachineApplication {

    @Configuration
    @EnableStateMachine
    static class StateMachineConfig
            extends StateMachineConfigurerAdapter<String, String> {

        @Override
        public void configure(StateMachineStateConfigurer<String, String> states)
                throws Exception {
            states.withStates()
                    .initial(PLACED)
                    .state(PROCESSING)
                    .state(SENT)
                    .state(DELIVERED);
        }

        @Override
        public void configure(StateMachineTransitionConfigurer<String, String> transitions)
                throws Exception {
            transitions
                    .withExternal().event(PROCESS).source(PLACED).target(PROCESSING)
                    .and()
                    .withExternal().event(SEND).source(PROCESSING).target(SENT)
                    .and()
                    .withExternal().event(DELIVER).source(SENT).target(DELIVERED)
                    .and()
                    .withExternal().event(TEST).source(PLACED).target(SENT)
            ;
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
        private String state;
    }

    public static class Event {
        public static final String PROCESS = "PROCESS";
        public static final String SEND = "SEND";
        public static final String DELIVER = "DELIVER";
        public static final String TEST = "TEST";
    }

    public static class STATE {
        public static final String PLACED = "PLACED";
        public static final String PROCESSING = "PROCESSING";
        public static final String SENT = "SENT";
        public static final String DELIVERED = "DELIVERED";
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(StateMachineApplication.class, args);
    }

}