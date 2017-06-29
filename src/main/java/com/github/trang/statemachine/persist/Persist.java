package com.github.trang.statemachine.persist;

import com.github.trang.statemachine.model.domain.House;
import com.github.trang.statemachine.model.enums.States;
import com.github.trang.statemachine.service.HouseService;
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
    private HouseService houseService;

    private final PersistStateMachineHandler handler;
    private final PersistStateChangeListener listener;

    public Persist(PersistStateMachineHandler handler) {
        this.handler = handler;
        this.listener = persistStateChangeListener();
    }

    public void change(long housedelCode, String event) {
        House house = houseService.selectByPk(housedelCode);
        Message<String> message = MessageBuilder.withPayload(event)
                .setHeader("housedelCode", housedelCode)
                .build();
        handler.handleEventWithState(message, States.findState(house.status()));
    }

    private PersistStateChangeListener persistStateChangeListener() {
        return (state, message, transition, stateMachine) ->
                Optional.ofNullable(message)
                        .map(Message::getHeaders)
                        .filter(m -> m.containsKey("housedelCode"))
                        .map(m -> m.get("housedelCode", Long.class))
                        .map(id -> new House().id(id).status(States.findStatus(state.getId())))
                        .ifPresent(del -> houseService.update(del));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.handler == null) {
            throw new IllegalStateException("handler can't be null!");
        }
        this.handler.addPersistStateChangeListener(listener);
    }

}