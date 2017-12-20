package com.lanou.cost.mapper;

import com.lanou.cost.bean.Cost;

import java.util.List;

public interface CostMapper {
    int insert(Cost record);

    int insertSelective(Cost record);
    
    List<Cost> getAllCost();

    int delCost(Cost cost);
}