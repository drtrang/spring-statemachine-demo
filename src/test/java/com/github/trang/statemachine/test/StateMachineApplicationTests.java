package com.github.trang.statemachine.test;

import com.github.trang.statemachine.StateMachineApplication.Event;
import com.github.trang.statemachine.config.Persist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.trang.statemachine.StateMachineApplication.Event.DELIVER;
import static com.github.trang.statemachine.StateMachineApplication.Event.PROCESS;
import static com.github.trang.statemachine.StateMachineApplication.Event.SEND;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StateMachineApplicationTests {

    @Autowired
    private Persist persist;

    @Test
    public void test() {
        System.out.println("INIT：" + persist.listDbEntries());
        persist.change(1, SEND);
        persist.change(1, DELIVER);
        System.out.println("ERROR：" + persist.listDbEntries());
        persist.change(1, PROCESS);
        System.out.println("PROCESS：" + persist.listDbEntries());
        persist.change(1, SEND);
        System.out.println("SEND：" + persist.listDbEntries());
        persist.change(1, DELIVER);
        System.out.println("DELIVER：" + persist.listDbEntries());
    }

    @Test
    public void test2() {
        System.out.println("INIT：" + persist.listDbEntries());
        persist.change(1, PROCESS);
        System.out.println("PROCESS：" + persist.listDbEntries());
        persist.change(1, Event.TEST);
        System.out.println("TEST：" + persist.listDbEntries());
    }

}