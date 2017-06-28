package com.github.trang.statemachine.config;

import com.github.trang.statemachine.StateMachineApplication.Order;
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

/**
 * @author trang
 */
@Getter
public class Persist {

    private final PersistStateMachineHandler handler;

    private final PersistStateChangeListener listener = (state, message, transition, stateMachine) -> {
        if (message != null && message.getHeaders().containsKey("order")) {
            Integer id = message.getHeaders().get("order", Integer.class);
            Persist.MAP.get(id).setState(state.getId());
        }
    };

    public Persist(PersistStateMachineHandler handler) {
        this.handler = handler;
        this.handler.addPersistStateChangeListener(listener);
    }

    public static final List<Order> ORDERS = Arrays.asList(
            new Order(1, "PLACED"),
            new Order(2, "PROCESSING"),
            new Order(3, "SENT"),
            new Order(4, "DELIVERED")
    );

    public static final Map<Integer, Order> MAP = Maps.uniqueIndex(ORDERS, Order::getId);

    public String listDbEntries() {
        return new Gson().toJson(ORDERS);
    }

    public void change(int order, String event) {
        Order o = MAP.get(order);
        Message<String> message = MessageBuilder.withPayload(event).setHeader("order", order).build();
        handler.handleEventWithState(message, o.getState());
    }

}