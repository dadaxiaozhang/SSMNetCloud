package com.lanou.login.service.Impl;

import com.lanou.admin.bean.AdminList;
import com.lanou.bean.AdminRole;
import com.lanou.login.bean.AdminInfo;
import com.lanou.bean.ModuleInfo;
import com.lanou.login.mapper.AdminInfoMapper;
import com.lanou.login.service.AdminInfoService;
import com.lanou.mapper.AdminRoleMapper;
import com.lanou.role.bean.RoleInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/7.
 * 嗯，这是这个工程唯一的注释
 */
@Service(value = "loginService")
public class AdminInfoServiceImpl implements AdminInfoService {

    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Resource
    private AdminRoleMapper adminRoleMapper;

    @Override
    public AdminInfo checkUser(AdminInfo admin) {

        return adminInfoMapper.checkUser(admin);
    }

    @Override
    public List<ModuleInfo> getModule(int adminId) {
        return adminInfoMapper.getModule(adminId);
    }

    @Override
    public List<AdminList> getAdmin() {
        return adminInfoMapper.getAdmin();
    }

    @Override
    public int insert(AdminInfo record) {
        return adminInfoMapper.insert(record);
    }

    @Override
    public Integer getAdminCodebyid(String admin_code) {
        return adminInfoMapper.getAdminCodebyid(admin_code);
    }

    @Override
    public int insert(AdminRole record) {
        return adminRoleMapper.insert(record);
    }

    @Override
    public int delAdmin(AdminInfo adminInfo) {
        return adminInfoMapper.delAdmin(adminInfo);
    }

    @Override
    public int delAR(AdminRole adminRole) {
        return adminRoleMapper.delAR(adminRole);
    }

    @Override
    public void update(AdminInfo adminInfo) {
        adminInfoMapper.update(adminInfo);
    }

    @Override
    public int resetPwd(int adminId) {
        return adminInfoMapper.resetPwd(adminId);
    }

    @Override
    public List<AdminList> getAdminByCondition(RoleInfo roleInfo) {
        return adminInfoMapper.getAdminByCondition(roleInfo);
    }


}
