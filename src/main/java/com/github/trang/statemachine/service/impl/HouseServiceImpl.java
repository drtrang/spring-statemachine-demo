package com.github.trang.statemachine.service.impl;

import com.github.trang.statemachine.model.domain.House;
import com.github.trang.statemachine.service.HouseService;
import org.springframework.stereotype.Service;

@Service("houseService")
public class HouseServiceImpl extends BaseServiceImpl<House, Long> implements HouseService {
}