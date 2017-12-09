package com.lanou.login.service.Impl;

import com.lanou.login.bean.AdminInfo;
import com.lanou.bean.ModuleInfo;
import com.lanou.login.mapper.AdminInfoMapper;
import com.lanou.login.service.AdminInfoService;
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

    @Override
    public AdminInfo checkUser(AdminInfo admin) {

        return adminInfoMapper.checkUser(admin);
    }

    @Override
    public List<ModuleInfo> getModule(int adminId) {
        return adminInfoMapper.getModule(adminId);
    }


}
