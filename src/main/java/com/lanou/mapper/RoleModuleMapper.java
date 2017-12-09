package com.lanou.mapper;

import com.lanou.bean.RoleModule;

public interface RoleModuleMapper {
    int insert(RoleModule record);

    int insertSelective(RoleModule record);
}