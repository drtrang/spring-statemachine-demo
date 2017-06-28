package com.github.trang.statemachine.controller;

import com.github.trang.statemachine.model.enums.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author trang
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StateMachine<String, String> stateMachine;

    @GetMapping("/change/{id}")
    public void change(@PathVariable Long id) {
        Message<String> message = MessageBuilder.withPayload(Events.E1_8.name())
                .setHeader("housedelCode", id)
                .build();
        stateMachine.sendEvent(message);
    }

    @GetMapping("/end/{id}")
    public void end(@PathVariable Long id) {
        Message<String> message = MessageBuilder.withPayload(Events.E1_8.name())
                .setHeader("housedelCode", id)
                .build();
        stateMachine.stop();
    }

}