package com.github.trang.statemachine.persist;

import com.github.trang.statemachine.model.domain.Housedel;
import com.github.trang.statemachine.model.enums.EnumHousedelStatus;
import com.github.trang.statemachine.service.HousedelService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler.PersistStateChangeListener;

import java.util.Optional;

/**
 * @author trang
 */
public class Persist implements InitializingBean {

    @Autowired
    private HousedelService housedelService;

    private final PersistStateMachineHandler handler;
    private final PersistStateChangeListener listener;

    public Persist(PersistStateMachineHandler handler) {
        this.handler = handler;
        this.listener = persistStateChangeListener();
    }

    public void change(long housedelCode, String event) {
        Housedel del = housedelService.selectByPk(housedelCode);
        Message<String> message = MessageBuilder.withPayload(event)
                .setHeader("housedelCode", housedelCode)
                .build();
        handler.handleEventWithState(message, EnumHousedelStatus.getState(del.getDelStatus()));
    }

    private PersistStateChangeListener persistStateChangeListener() {
        return (state, message, transition, stateMachine) ->
                Optional.ofNullable(message)
                        .map(Message::getHeaders)
                        .filter(m -> m.containsKey("housedelCode"))
                        .map(m -> m.get("housedelCode", Long.class))
                        .map(id -> Housedel.builder()
                                .housedelCode(id)
                                .delStatus(EnumHousedelStatus.getStatus(state.getId()))
                                .build())
                        .ifPresent(del -> housedelService.update(del));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.handler == null) {
            throw new IllegalStateException("handler can't be null!");
        }
        this.handler.addPersistStateChangeListener(listener);
    }

}