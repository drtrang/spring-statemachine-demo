package com.github.trang.statemachine.config;

import com.github.trang.statemachine.model.domain.Housedel;
import com.github.trang.statemachine.service.HousedelService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler.PersistStateChangeListener;

/**
 * @author trang
 */
@AllArgsConstructor
@Builder
@Getter
public class Persist implements InitializingBean {

    private PersistStateMachineHandler handler;
    private PersistStateChangeListener listener;

    @Autowired
    private HousedelService housedelService;

    public Housedel get(Long pk) {
        return housedelService.selectByPk(pk);
    }

    public void change(long housedelCode, String event) {
        Housedel del = housedelService.selectByPk(housedelCode);
        Message<String> message = MessageBuilder.withPayload(event).setHeader("housedel", del).build();
        handler.handleEventWithState(message, del.getDelStatus().toString());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }

}