package com.github.trang.statemachine.config;

import com.github.trang.statemachine.annotation.StateMachineConfig.Order;
import com.github.trang.statemachine.annotation.StateMachineConfig.State;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import lombok.Getter;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler.PersistStateChangeListener;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.github.trang.statemachine.annotation.StateMachineConfig.State.*;

/**
 * @author trang
 */
@Getter
public class Persist {

    private final PersistStateMachineHandler handler;

    private final PersistStateChangeListener listener = (state, message, transition, stateMachine) -> {
        if (message != null && message.getHeaders().containsKey("order")) {
            Integer id = message.getHeaders().get("order", Integer.class);
            Persist.MAP.get(id).setState(State.getStatus(state.getId()));
        }
    };

    public Persist(PersistStateMachineHandler handler) {
        this.handler = handler;
        this.handler.addPersistStateChangeListener(listener);
    }

    public static final List<Order> ORDERS = Arrays.asList(
            new Order(1, PLACED.getStatus()),//"PLACED"
            new Order(2, PROCESSING.getStatus()),//"PROCESSING"
            new Order(3, SENT.getStatus()),//"SENT"
            new Order(4, DELIVERED.getStatus())//"DELIVERED"
    );

    public static final Map<Integer, Order> MAP = Maps.uniqueIndex(ORDERS, Order::getId);

    public String listDbEntries() {
        return new Gson().toJson(ORDERS);
    }

    public void change(int id, String event) {
        Order order = MAP.get(id);
        Message<String> message = MessageBuilder.withPayload(event).setHeader("order", id).build();
        handler.handleEventWithState(message, State.getState(order.getState()));
    }

}