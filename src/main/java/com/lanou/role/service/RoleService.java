package com.lanou.role.service;

import com.lanou.bean.RoleModule;
import com.lanou.role.bean.RoleInfo;
import com.lanou.role.bean.RoleList;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dllo on 17/12/11.
 * 嗯，这是这个工程唯一的注释
 */

public interface RoleService {

    List<RoleList> getRole();

    void insert(RoleInfo record);

    int insert(RoleModule record);

    RoleInfo getRoleByName(RoleInfo roleInfo);

    int deleteRole(RoleInfo roleInfo);

    int deleteRm(int roleId);

    void updateRole(RoleInfo roleInfo);


}
