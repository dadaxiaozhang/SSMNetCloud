package com.lanou.admin.controller;

import com.lanou.admin.bean.AdminList;
import com.lanou.bean.AdminRole;
import com.lanou.login.bean.AdminInfo;
import com.lanou.login.service.Impl.AdminInfoServiceImpl;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/15.
 * 嗯，这是这个工程唯一的注释
 */
@Controller
public class AdminController {

    @Resource(name = "loginService")
    private AdminInfoServiceImpl adminInfoService;

    //    跳转管理员页面
    @RequestMapping(value = "/toAdmin")
    public String toAdmin() {

        return "admin/admin_list";
    }

    //    获取管理员信息及角色信息
    @RequestMapping(value = "/getAdmin")
    @ResponseBody
    public AjaxResult getAdmin(HttpSession session) {

        AjaxResult ajaxResult = new AjaxResult();
        List<AdminList> adminList = adminInfoService.getAdmin();
        List<String> adminCodeList = new ArrayList<>();
        for (int i = 0; i < adminList.size(); i++) {
            String adminCode = adminList.get(i).getAdmin_code();
            adminCodeList.add(adminCode);
        }

        session.setAttribute("admin_code", adminCodeList);
        ajaxResult.setData(adminList);
        return ajaxResult;
    }

    //    添加管理员页面跳转
    @RequestMapping(value = "/toAddAdmin")
    public String toAddAdmin() {
        return "admin/admin_add";
    }

    //    添加管理员信息
    @RequestMapping(value = "/addAdmin")
    @ResponseBody
    public AjaxResult addAdmin(AdminInfo adminInfo, Integer[] roleId, HttpSession session) {
        AjaxResult ajaxResult = new AjaxResult();
        AdminRole adminRole = new AdminRole();
        List<String> admin_code = (List<String>) session.getAttribute("admin_code");
        int flag = 0;
        for (int i = 0; i < admin_code.size(); i++) {
            if (admin_code.get(i).equals(adminInfo.getAdmin_code())) {
                flag = 1;
            }
        }
        if (flag == 1) {
            ajaxResult.setErrorCode(404);
            ajaxResult.setMsg("用户名已存在");
            return ajaxResult;
        }
        java.util.Date date = new java.util.Date();
        long times = date.getTime();
        adminInfo.setEnrolldate(new Date(times));
        adminInfoService.insert(adminInfo);
        Integer admin_id = adminInfoService.getAdminCodebyid(adminInfo.getAdmin_code());
        adminRole.setAdminId(admin_id);
        for (int i = 0; i < roleId.length; i++) {
            adminRole.setRoleId(roleId[i]);
            adminInfoService.insert(adminRole);
        }
        return ajaxResult;
    }
}
