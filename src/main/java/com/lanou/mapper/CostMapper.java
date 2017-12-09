package com.lanou.mapper;

import com.lanou.bean.Cost;

public interface CostMapper {
    int insert(Cost record);

    int insertSelective(Cost record);
}