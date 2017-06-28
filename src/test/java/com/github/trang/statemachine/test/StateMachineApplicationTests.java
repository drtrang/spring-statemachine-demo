package com.github.trang.statemachine.test;

import com.github.trang.statemachine.config.Persist;
import com.github.trang.statemachine.model.enums.Events;
import com.github.trang.statemachine.service.HousedelService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StateMachineApplicationTests {

    @Autowired
    private HousedelService housedelService;
    @Autowired
    private StateMachine<String, String> stateMachine;
    @Autowired
    private Persist persist;
    @Autowired
    private Gson gson;

    @Test
    public void test() {
        System.out.println("INIT：" + persist.get(1L));
        persist.change(1L, Events.TRANSFER);
        System.out.println("ERROR：" + persist.get(1L));
        persist.change(1L, Events.INTENTION);
        System.out.println("INTENTION：" + persist.get(1L));
        persist.change(1L, Events.PAY);
        System.out.println("PAY：" + persist.get(1L));
        persist.change(1L, Events.CONTRACT);
        System.out.println("CONTRACT：" + persist.get(1L));
    }

    @Test
    public void test2() {
        System.out.println("INIT：" + persist.get(1L));
        persist.change(1L, Events.TRANSFER);
        System.out.println("TRANSFER：" + persist.get(1L));
    }

}
