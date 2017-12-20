package com.lanou.cost.service;

import com.lanou.cost.bean.Cost;

import java.util.List;

/**
 * Created by dllo on 17/12/18.
 * 嗯，这是这个工程唯一的注释
 */
public interface CostService {

    int insert(Cost record);

    List<Cost> getAllCost();

    int delCost(Cost cost);
}
