package com.lanou.updatepwd.service.Impl;

import com.lanou.login.bean.AdminInfo;
import com.lanou.login.mapper.AdminInfoMapper;
import com.lanou.updatepwd.service.UpdatePwdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/12/11.
 * 嗯，这是这个工程唯一的注释
 */
@Service(value = "updatePwdService")
public class UpdatePwdServiceImpl implements UpdatePwdService {

    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Override
    public void updatePwd(AdminInfo admin) {
        adminInfoMapper.updatePwd(admin);
    }
}
