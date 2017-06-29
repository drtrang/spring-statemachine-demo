package com.github.trang.statemachine.mapper;

import com.github.trang.statemachine.model.domain.House;
import com.github.trang.statemachine.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseMapper extends BaseMapper<House> {
}