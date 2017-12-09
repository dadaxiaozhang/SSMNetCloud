package com.lanou.mapper;

import com.lanou.bean.Service;

public interface ServiceMapper {
    int insert(Service record);

    int insertSelective(Service record);
}