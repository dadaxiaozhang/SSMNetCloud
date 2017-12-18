package com.lanou.updatepwd.controller;

import com.lanou.information.service.Impl.InfoServiceImpl;
import com.lanou.login.bean.AdminInfo;
import com.lanou.updatepwd.service.Impl.UpdatePwdServiceImpl;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by dllo on 17/12/11.
 * 嗯，这是这个工程唯一的注释
 */
@Controller
public class UpdatePwd {

    @Resource(name = "updatePwdService")
    private UpdatePwdServiceImpl updatePwdService;

    @Resource(name = "InfoService")
    private InfoServiceImpl InfoService;

    //    修改密码页跳转
    @RequestMapping("/updatePwd")
    public String updatePwd(){

        return "user/user_modi_pwd";
    }

    @RequestMapping(value = "/savePwd")
    @ResponseBody
    public AjaxResult savePwd(HttpSession session, AdminInfo admin,String newPwd){

        AjaxResult ajaxResult =new AjaxResult();

        AdminInfo admin1 = (AdminInfo) session.getAttribute("loginAdmin");
        if (admin1.getPassword().equals(admin.getPassword()))
        {
            admin.setAdmin_id(admin1.getAdmin_id());
            admin.setPassword(newPwd);
            updatePwdService.updatePwd(admin);
            System.out.println(admin);
            AdminInfo adminInfo = InfoService.getUser(admin1);
            session.removeAttribute("loginAdmin");
            session.setAttribute("loginAdmin",adminInfo);
            ajaxResult.setErrorCode(200);
        }else {
            ajaxResult.setErrorCode(404);
        }
        return ajaxResult;
    }
}
