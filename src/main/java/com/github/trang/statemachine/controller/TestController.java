package com.github.trang.statemachine.controller;

import com.github.trang.statemachine.model.enums.EnumHousedelStatus;
import com.github.trang.statemachine.model.enums.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
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
    private StateMachine<EnumHousedelStatus, Events> stateMachine;

    @GetMapping("/toA/{id}")
    public HttpEntity<String> toA(@PathVariable Long id) {
        Message<Events> message = MessageBuilder.withPayload(Events.意向金起草)
                .setHeader("housedelCode", id)
                .build();
        stateMachine.sendEvent(message);
        return ResponseEntity.ok("ok");
    }


}
