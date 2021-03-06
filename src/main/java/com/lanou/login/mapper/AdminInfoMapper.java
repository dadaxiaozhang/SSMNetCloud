package com.lanou.login.mapper;

import com.lanou.admin.bean.AdminList;
import com.lanou.login.bean.AdminInfo;
import com.lanou.bean.ModuleInfo;
import com.lanou.role.bean.RoleInfo;

import java.util.List;

public interface AdminInfoMapper {

    int insert(AdminInfo record);

    int insertSelective(AdminInfo record);

//    登录时查询账户是否存在并返回用户数据
    AdminInfo checkUser(AdminInfo admin);

//    通过用户id查询用户权限
    List<ModuleInfo> getModule(int adminId);
//    更新用户信息
    void updateUser(AdminInfo admin);
//    根据用户id查询用户信息
    AdminInfo getUser(AdminInfo admin);
//    修改密码
    void updatePwd(AdminInfo admin);
//    获取所有管理员信息
    List<AdminList> getAdmin();
//    根据账户名获取管理员id
    Integer getAdminCodebyid(String admin_code);

//    根据管理员id删除对应信息
    int delAdmin(AdminInfo adminInfo);

//    修改管理员信息
    void update(AdminInfo adminInfo);
//   重置密码
    int resetPwd(int adminId);
//    高级查询
    List<AdminList> getAdminByCondition(RoleInfo roleInfo);
}