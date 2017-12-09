package com.lanou.login.controller;

import com.lanou.login.bean.AdminInfo;
import com.lanou.bean.ModuleInfo;
import com.lanou.login.service.AdminInfoService;
import com.lanou.login.service.Impl.AdminInfoServiceImpl;
import com.lanou.utils.AjaxResult;
import com.lanou.utils.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/12/7.
 * 嗯，这是这个工程唯一的注释
 */
@Controller
public class LoginController {

    @Resource(name = "loginService")
    private AdminInfoServiceImpl adminInfoService;
    //验证码中的内容
    private String codeContent;

    //    验证码
    @RequestMapping(value = "/verifyCode")
    public void verifyCode(HttpServletResponse response) throws IOException {

        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        codeContent = verifyCode.getText().toLowerCase();
        verifyCode.output(image, response.getOutputStream());

    }

    //    登录
    @RequestMapping(value = "/login")
    @ResponseBody
    public AjaxResult login(AdminInfo admin, String code, HttpSession session) {

        AjaxResult ajaxResult = new AjaxResult();
        if (admin.getAdminCode() != null && admin.getPassword() != null && code != null) {
//            equalsIgnoreCase()忽略大小写比较字符串是否相同
            if (!code.trim().equalsIgnoreCase(codeContent)) {
                ajaxResult.setErrorCode(404);
                ajaxResult.setMsg("验证码错误");
                return ajaxResult;
            }

            AdminInfo adminOut = adminInfoService.checkUser(admin);
            System.out.println(adminOut);
            List<ModuleInfo> moduleInfoList = adminInfoService.getModule(adminOut.getAdminId());
            session.setAttribute("loginAccess",moduleInfoList);
            session.setAttribute("loginAdmin", adminOut);

            if (adminOut != null && code.trim().equalsIgnoreCase(codeContent)) {

                ajaxResult.setErrorCode(200);

            } else {
                ajaxResult.setErrorCode(404);
                ajaxResult.setMsg("帐户名或登录密码不正确，请重新输入");
            }
        }

        return ajaxResult;
    }

    //登录
    @RequestMapping("/index")
    public String frontPage(){

        return "index";
    }

    public String getCodeContent() {
        return codeContent;
    }

    public void setCodeContent(String codeContent) {
        this.codeContent = codeContent;
    }
}

