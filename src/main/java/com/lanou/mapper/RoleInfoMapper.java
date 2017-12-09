package com.lanou.mapper;

import com.lanou.bean.RoleInfo;

public interface RoleInfoMapper {
    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);
}