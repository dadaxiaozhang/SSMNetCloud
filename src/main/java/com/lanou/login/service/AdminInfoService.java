package com.lanou.login.service;

import com.lanou.admin.bean.AdminList;
import com.lanou.bean.AdminRole;
import com.lanou.login.bean.AdminInfo;
import com.lanou.bean.ModuleInfo;
import com.lanou.role.bean.RoleInfo;

import java.util.List;

/**
 * Created by dllo on 17/12/7.
 * 嗯，这是这个工程唯一的注释
 */
public interface AdminInfoService {
    
    AdminInfo checkUser(AdminInfo admin);

    List<ModuleInfo> getModule(int adminId);

    List<AdminList> getAdmin();

    int insert(AdminInfo record);

    Integer getAdminCodebyid(String admin_code);

    int insert(AdminRole record);

    int delAdmin(AdminInfo adminInfo);

    int delAR(AdminRole adminRole);

    void update(AdminInfo adminInfo);

    int resetPwd(int adminId);

    List<AdminList> getAdminByCondition(RoleInfo roleInfo);
}
