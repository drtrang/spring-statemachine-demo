package com.github.trang.statemachine.controller;

import com.github.trang.statemachine.model.domain.Housedel;
import com.github.trang.statemachine.service.HousedelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author trang
 */
@RestController
@RequestMapping("/house")
public class HousedelController {

    @Autowired
    private HousedelService housedelService;

    @GetMapping("/get/{id}")
    public Housedel getById(@PathVariable Long id) {
        return housedelService.selectByPk(id);
    }

    @GetMapping("/get/phone/{phones}")
    public List<Housedel> getByPhone(@PathVariable List<String> phones) {
        String phone = phones.get(0);
        return housedelService.select(Housedel.builder().ownerMobilePhone1(phone).build());
    }

    @GetMapping("/list/{ids}")
    public List<Housedel> getByIds(@PathVariable List<Long> ids) {
        return housedelService.selectByIds(ids);
    }

}