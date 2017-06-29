package com.github.trang.statemachine.handler;

import com.github.trang.statemachine.model.enums.Events;
import com.github.trang.statemachine.model.enums.States;
import org.springframework.messaging.Message;
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.annotation.EventHeaders;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

import java.util.Map;

/**
 * @author trang
 */
@WithStateMachine
public class EventHandler {

    @OnTransition(source = States.VALID, target = States.DRAFT_INTENTION)
    public void change(@EventHeaders Map<String, Object> headers,
                    ExtendedState extendedState,
                    StateMachine<String, String> stateMachine,
                    Message<Events> message,
                    Exception e) {
        System.out.println("测试 @OnTransition");
    }

}