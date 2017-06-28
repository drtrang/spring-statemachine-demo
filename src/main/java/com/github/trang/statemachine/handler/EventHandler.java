package com.github.trang.statemachine.handler;

import com.github.trang.statemachine.annotation.StatesOnTransition;
import com.github.trang.statemachine.model.domain.Housedel;
import com.github.trang.statemachine.model.enums.EnumHousedelStatus;
import com.github.trang.statemachine.model.enums.Events;
import com.github.trang.statemachine.service.HousedelService;
import com.google.common.primitives.Ints;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private HousedelService housedelService;

    @StatesOnTransition(source = EnumHousedelStatus.VALID, target = EnumHousedelStatus.DRAFT_INTENTION)
    public void change(@EventHeaders Map<String, Object> headers,
                    ExtendedState extendedState,
                    StateMachine<String, String> stateMachine,
                    Message<Events> message,
                    Exception e) {
        Long housedelCode = (Long) headers.get("housedelCode");
        Housedel param = Housedel.builder()
                .housedelCode(housedelCode)
                .delStatus(Ints.tryParse(EnumHousedelStatus.DRAFT_INTENTION.getValue()))
                .build();
        housedelService.update(param);
    }

    @StatesOnTransition(target = EnumHousedelStatus.INVALID)
    public void end(@EventHeaders Map<String, Object> headers) {
        Long housedelCode = (Long) headers.get("housedelCode");
        Housedel param = Housedel.builder()
                .housedelCode(housedelCode)
                .delStatus(Ints.tryParse(EnumHousedelStatus.INVALID.getValue()))
                .build();
        housedelService.update(param);
    }

}