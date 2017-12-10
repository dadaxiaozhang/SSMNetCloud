package com.lanou.information.service.Impl;

import com.lanou.information.service.InfoService;
import com.lanou.login.bean.AdminInfo;
import com.lanou.login.mapper.AdminInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/12/10.
 * 嗯，这是这个工程唯一的注释
 */
@Service(value = "InfoService")
public class InfoServiceImpl implements InfoService {

    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Override
    public void updateUser(AdminInfo admin) {

        adminInfoMapper.updateUser(admin);
    }

    @Override
    public AdminInfo getUser(AdminInfo admin) {
        return adminInfoMapper.getUser(admin);
    }
}
