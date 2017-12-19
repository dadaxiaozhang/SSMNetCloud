package com.lanou.cost.service.Impl;

import com.lanou.cost.bean.Cost;
import com.lanou.cost.mapper.CostMapper;
import com.lanou.cost.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/18.
 * 嗯，这是这个工程唯一的注释
 */
@Service(value = "CostService")
public class CostServiceImpl implements CostService {

    @Resource
    private CostMapper costMapper;

    @Override
    public int insert(Cost record) {
        return costMapper.insert(record);
    }

    @Override
    public List<Cost> getAllCost() {
        return costMapper.getAllCost();
    }
}
