package com.github.trang.statemachine.test;

import com.github.trang.statemachine.config.Persist;
import com.github.trang.statemachine.model.enums.Events;
import com.github.trang.statemachine.service.HousedelService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StateMachineApplicationTests {

    @Autowired
    private HousedelService housedelService;
    @Autowired
    private StateMachine<String, String> stateMachine;
    @Autowired
    private Persist persist;
    @Autowired
    private Gson gson;

    @Test
    public void base() {
        System.out.println(gson.toJson(housedelService.selectByPk(101100000001L)));
    }

    @Test
    public void update() {
        System.out.println(gson.toJson(persist.get(1L)));
        Message<String> message = MessageBuilder.withPayload(Events.E0.name())
                .setHeader("housedelCode", 1L)
                .build();
        persist.change(1L, Events.E0.name());
        System.out.println(gson.toJson(persist.get(1L)));
    }

}
