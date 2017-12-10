package com.lanou.login.service;

import com.lanou.login.bean.AdminInfo;
import com.lanou.bean.ModuleInfo;

import java.util.List;

/**
 * Created by dllo on 17/12/7.
 * 嗯，这是这个工程唯一的注释
 */
public interface AdminInfoService {
    
    AdminInfo checkUser(AdminInfo admin);

    List<ModuleInfo> getModule(int adminId);


}
