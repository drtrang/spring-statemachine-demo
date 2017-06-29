package com.github.trang.statemachine.test;

import com.github.trang.statemachine.model.enums.Events;
import com.github.trang.statemachine.persist.Persist;
import com.github.trang.statemachine.service.HousedelService;
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
    private StateMachine<String, String> stateMachine;
    @Autowired
    private Persist persist;
    @Autowired
    private HousedelService housedelService;
    
    @Test
    public void test() {
        System.out.println("INIT：" + housedelService.selectByPk(1L));
        persist.change(1L, Events.TRANSFER);
        System.out.println("ERROR：" + housedelService.selectByPk(1L));
        persist.change(1L, Events.INTENTION);
        System.out.println("INTENTION：" + housedelService.selectByPk(1L));
        persist.change(1L, Events.PAY);
        System.out.println("PAY：" + housedelService.selectByPk(1L));
        persist.change(1L, Events.CONTRACT);
        System.out.println("CONTRACT：" + housedelService.selectByPk(1L));
    }

    @Test
    public void test2() {
        System.out.println("INIT：" + housedelService.selectByPk(1L));
        persist.change(1L, Events.TRANSFER);
        System.out.println("TRANSFER：" + housedelService.selectByPk(1L));
    }

    @Test
    public void invalid() {
        System.out.println("INIT：" + housedelService.selectByPk(1L));
        persist.change(1L, Events.INVALID);
        System.out.println("INVALID：" + housedelService.selectByPk(1L));
    }

    @Test
    public void add() {
        System.out.println("INIT：" + housedelService.selectByPk(1L));
        //persist.change(1L, Events.ADD);
        stateMachine.sendEvent(Events.ADD);
        System.out.println("INVALID：" + housedelService.selectByPk(1L));
    }

}
