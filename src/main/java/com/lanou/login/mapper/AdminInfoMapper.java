package com.lanou.login.mapper;

import com.lanou.login.bean.AdminInfo;
import com.lanou.bean.ModuleInfo;

import java.util.List;

public interface AdminInfoMapper {

    int insert(AdminInfo record);

    int insertSelective(AdminInfo record);

    AdminInfo checkUser(AdminInfo admin);

    List<ModuleInfo> getModule(int adminId);
}