package com.github.trang.statemachine.handler;

import com.github.trang.statemachine.annotation.StatesOnTransition;
import com.github.trang.statemachine.config.StateMachineConfig.Events;
import com.github.trang.statemachine.config.StateMachineConfig.States;
import org.springframework.messaging.Message;
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.annotation.EventHeaders;
import org.springframework.statemachine.annotation.WithStateMachine;

import java.util.Map;

/**
 * @author trang
 */
@WithStateMachine
public class EventHandler {

    @StatesOnTransition(source = States.S0, target = States.S1)
    public void add(@EventHeaders Map<String, Object> headers,
                    ExtendedState extendedState,
                    StateMachine<States, Events> stateMachine,
                    Message<Events> message,
                    Exception e) {
        System.out.println("处理 S0 -> S1 状态流转");
    }

}
