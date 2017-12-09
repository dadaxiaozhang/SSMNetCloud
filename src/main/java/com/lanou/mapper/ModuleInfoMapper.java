package com.lanou.mapper;

import com.lanou.bean.ModuleInfo;

public interface ModuleInfoMapper {
    int insert(ModuleInfo record);

    int insertSelective(ModuleInfo record);
}