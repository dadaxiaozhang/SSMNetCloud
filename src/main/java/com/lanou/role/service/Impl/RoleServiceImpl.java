package com.lanou.role.service.Impl;

import com.lanou.bean.RoleModule;
import com.lanou.mapper.RoleModuleMapper;
import com.lanou.role.bean.RoleInfo;
import com.lanou.role.bean.RoleList;
import com.lanou.role.mapper.RoleInfoMapper;
import com.lanou.role.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/11.
 * 嗯，这是这个工程唯一的注释
 */
@Service(value = "RoleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleInfoMapper roleInfoMapper;

    @Resource
    private RoleModuleMapper roleModuleMapper;

    @Override
    public List<RoleList> getRole() {
        return roleInfoMapper.getRole();
    }

    @Override
    public void insert(RoleInfo record) {
        roleInfoMapper.insert(record);
    }

    @Override
    public int insert(RoleModule record) {
        return roleModuleMapper.insert(record);
    }

    @Override
    public RoleInfo getRoleByName(RoleInfo roleInfo) {
        return roleInfoMapper.getRoleByName(roleInfo);
    }

    @Override
    public int deleteRole(RoleInfo roleInfo) {
       return roleInfoMapper.deleteRole(roleInfo);
    }

    @Override
    public int deleteRm(int roleId) {
       return roleModuleMapper.deleteRm(roleId);
    }

    @Override
    public void updateRole(RoleInfo roleInfo) {
        roleInfoMapper.updateRole(roleInfo);
    }

    @Override
    public List<RoleInfo> getAllRole() {
        return roleInfoMapper.getAllRole();
    }


}
