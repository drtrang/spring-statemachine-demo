package com.github.trang.statemachine.handler;

import com.github.trang.statemachine.annotation.StatesOnTransition;
import com.github.trang.statemachine.model.domain.Housedel;
import com.github.trang.statemachine.model.enums.EnumHousedelStatus;
import com.github.trang.statemachine.model.enums.Events;
import com.github.trang.statemachine.service.HousedelService;
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
    public void toA(@EventHeaders Map<String, Object> headers,
                    ExtendedState extendedState,
                    StateMachine<EnumHousedelStatus, Events> stateMachine,
                    Message<Events> message,
                    Exception e) {
        Long housedelCode = (Long) headers.get("housedelCode");
        Housedel param = Housedel.builder()
                .housedelCode(housedelCode)
                .delStatus(EnumHousedelStatus.DRAFT_INTENTION.getValue())
                .build();
        housedelService.update(param);
    }

}
