package com.lanou.index.controller;

import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by dllo on 17/12/9.
 * 嗯，这是这个工程唯一的注释
 */
@Controller
public class IndexController {

    //获取主页登录权限生成图标
    @RequestMapping(value = "/getAccess")
    @ResponseBody
    public AjaxResult getAccess(HttpSession session){
        AjaxResult ajaxResult=new AjaxResult();
        ajaxResult.setData(session.getAttribute("loginAccess"));

        return ajaxResult;
    }

//    主页跳转
    @RequestMapping("/index")
    public String indexInfo() {

        return "index";
    }

}
