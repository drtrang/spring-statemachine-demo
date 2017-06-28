package com.github.trang.statemachine.test;

import com.github.trang.statemachine.model.domain.Housedel;
import com.github.trang.statemachine.service.HousedelService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StateMachineApplicationTests {

    @Autowired
    private HousedelService housedelService;
    @Autowired
    private Gson gson;

    @Test
    public void base() {
        System.out.println(gson.toJson(housedelService.selectByPk(101100000001L)));
    }

    @Test
    public void update() {
        Housedel param = Housedel.builder()
                .housedelCode(1L)
                .build();
        housedelService.updateUnchecked(param);
    }

}
