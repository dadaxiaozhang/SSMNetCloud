package com.lanou.mapper;

import com.lanou.bean.ServiceUpdateBak;

public interface ServiceUpdateBakMapper {
    int insert(ServiceUpdateBak record);

    int insertSelective(ServiceUpdateBak record);
}