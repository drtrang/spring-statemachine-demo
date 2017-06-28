package com.github.trang.statemachine.config;

import com.github.trang.statemachine.model.domain.Housedel;
import com.github.trang.statemachine.service.HousedelService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler.PersistStateChangeListener;

import java.util.Optional;

/**
 * @author trang
 */
@Getter
public class Persist {

    @Autowired
    private HousedelService housedelService;

    private final PersistStateMachineHandler handler;
    private final PersistStateChangeListener listener = (state, message, transition, stateMachine) ->
            Optional.ofNullable(message)
                    .map(Message::getHeaders)
                    .filter(m -> m.containsKey("housedel"))
                    .map(m -> m.get("housedel", Housedel.class))
                    .map(Housedel::getHousedelCode)
                    .map(id -> Housedel.builder().housedelCode(id).delStatus(0).build())
                    .ifPresent(del -> housedelService.update(del));

    public Persist(PersistStateMachineHandler handler) {
        this.handler = handler;
        this.handler.addPersistStateChangeListener(listener);
    }

    public Housedel get(Long pk) {
        return housedelService.selectByPk(pk);
    }

    public void change(long housedelCode, String event) {
        Housedel del = housedelService.selectByPk(housedelCode);
        Message<String> message = MessageBuilder.withPayload(event).setHeader("housedel", del).build();
        handler.handleEventWithState(message, del.getDelStatus().toString());
    }

}