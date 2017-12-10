package com.lanou.information.service;

import com.lanou.login.bean.AdminInfo;

/**
 * Created by dllo on 17/12/10.
 * 嗯，这是这个工程唯一的注释
 */
public interface InfoService {

    void updateUser(AdminInfo admin);

    AdminInfo getUser(AdminInfo admin);
}
