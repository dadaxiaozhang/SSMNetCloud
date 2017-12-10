package com.lanou.login.mapper;

import com.lanou.login.bean.AdminInfo;
import com.lanou.bean.ModuleInfo;

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
}