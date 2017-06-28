package com.github.trang.statemachine.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author trang
 */
@Getter
@Setter
@ToString
public class StateMachineEvent {

    private String message;
    private Date date;

    public StateMachineEvent(String message) {
        this.message = message;
        this.date = new Date();
    }

}
