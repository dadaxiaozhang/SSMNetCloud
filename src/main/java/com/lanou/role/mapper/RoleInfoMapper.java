package com.lanou.role.mapper;

import com.lanou.admin.bean.AdminList;
import com.lanou.role.bean.RoleInfo;
import com.lanou.role.bean.RoleList;

import java.util.List;

public interface RoleInfoMapper {
    void insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    List<RoleList> getRole();

    RoleInfo getRoleByName(RoleInfo roleInfo);

    int deleteRole(RoleInfo roleInfo);

    void updateRole(RoleInfo roleInfo);

    List<RoleInfo> getAllRole();
}