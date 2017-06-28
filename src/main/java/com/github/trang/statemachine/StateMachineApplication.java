package com.github.trang.statemachine;

import com.github.trang.statemachine.model.enums.EnumHousedelStatus;
import com.github.trang.statemachine.model.enums.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class StateMachineApplication implements CommandLineRunner {

    @Autowired
    private StateMachine<EnumHousedelStatus, Events> stateMachine;

    public static void main(String[] args) {
        SpringApplication.run(StateMachineApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

}
