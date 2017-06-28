package com.github.trang.statemachine;

import com.github.trang.statemachine.config.StateMachineConfig.Events;
import com.github.trang.statemachine.config.StateMachineConfig.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class StateMachineApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StateMachineApplication.class, args);
    }

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        stateMachine.sendEvent(Events.E0_1);
        stateMachine.sendEvent(Events.E0_1);
//        stateMachine.sendEvent(Events.E1_2);
//        stateMachine.sendEvent(Events.E1_3);
//        stateMachine.sendEvent(Events.E2_3);
    }

}
