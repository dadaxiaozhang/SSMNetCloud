package com.lanou.information.controller;

import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by dllo on 17/12/10.
 * 嗯，这是这个工程唯一的注释
 */
@Controller
public class InfoController {

    //    获取个人信息
    @RequestMapping(value = "/getInfo")
    @ResponseBody
    public AjaxResult getInfo(HttpSession session) {

        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setData(session.getAttribute("loginAdmin"));
        return ajaxResult;
    }

    //   个人信息页跳转
    @RequestMapping("/user_info")
    public String PersonalPage() {

        return "user/user_info";
    }
}
