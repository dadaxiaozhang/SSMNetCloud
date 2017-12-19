package com.lanou.admin.controller;

import com.lanou.admin.bean.AdminList;
import com.lanou.bean.AdminRole;
import com.lanou.login.bean.AdminInfo;
import com.lanou.login.service.Impl.AdminInfoServiceImpl;
import com.lanou.role.bean.RoleInfo;
import com.lanou.role.bean.RoleList;
import com.lanou.role.service.Impl.RoleServiceImpl;
import com.lanou.utils.AjaxResult;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

    @Resource(name = "RoleService")
    private RoleServiceImpl roleService;


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

    //    删除管理员
    @RequestMapping(value = "/deleteAdmin")
    @ResponseBody
    public AjaxResult delAdmin(AdminInfo adminInfo) {
        AjaxResult ajaxResult = new AjaxResult();
        AdminRole adminRole = new AdminRole();
        adminRole.setAdminId(adminInfo.getAdmin_id());
        int i = adminInfoService.delAdmin(adminInfo);
        int j = adminInfoService.delAR(adminRole);
        List<AdminList> admin = adminInfoService.getAdmin();
        if (i == 1 && j != 0) {
            ajaxResult.setErrorCode(200);
            ajaxResult.setData(admin);
        }
        return ajaxResult;
    }

    //    获取当前管理员名字id存到Session中
    @RequestMapping(value = "/jumpToAdmin")
    @ResponseBody
    public AjaxResult updateRole(AdminList adminList, HttpSession session) throws UnsupportedEncodingException {

        AjaxResult ajaxResult = new AjaxResult();
        adminList.setAdmin_code(URLDecoder.decode(adminList.getAdmin_code(), "UTF-8"));
        adminList.setName(URLDecoder.decode(adminList.getName(), "UTF-8"));
        adminList.setRole_name(URLDecoder.decode(adminList.getRole_name(), "UTF-8"));
        session.setAttribute("adminList", adminList);
        ajaxResult.setErrorCode(200);
        return ajaxResult;
    }

    //   管理员管理修改页面的跳转
    @RequestMapping(value = "/toUpdateAdmin")
    public String toUpdateRole() {
        return "admin/admin_modi";
    }

    @RequestMapping(value = "/getAdminInfo")
    @ResponseBody
    public AjaxResult getRoleInfo(HttpSession session) {
        AjaxResult ajaxResult = new AjaxResult();
        List<Integer> list = new ArrayList<>();
        AdminList adminList = (AdminList) session.getAttribute("adminList");
        List<RoleInfo> allRole = roleService.getAllRole();
        for (int i = 0; i < allRole.size(); i++) {
            if (adminList.getRole_name().contains(allRole.get(i).getName())) {
                list.add(allRole.get(i).getRoleId());
            } else list.add(0);
        }
        adminList.setRoleList(list);
        ajaxResult.setData(adminList);
        return ajaxResult;
    }

    //    修改管理员信息
    @RequestMapping(value = "/updateAdmin")
    @ResponseBody
    public AjaxResult updateAdmin(AdminInfo adminInfo, Integer[] roleId, HttpSession session) {
        AjaxResult ajaxResult = new AjaxResult();
        AdminRole adminRole = new AdminRole();
        AdminList adminList = (AdminList) session.getAttribute("adminList");
        adminInfo.setAdmin_id(adminList.getAdmin_id());
        adminInfoService.update(adminInfo);
        Integer admin_id = adminInfo.getAdmin_id();
        adminRole.setAdminId(admin_id);
        adminInfoService.delAR(adminRole);
        for (int i = 0; i < roleId.length; i++) {
            adminRole.setRoleId(roleId[i]);
            adminInfoService.insert(adminRole);
        }
        ajaxResult.setErrorCode(200);
        return ajaxResult;
    }
//    批量重置密码
    @RequestMapping(value = "/resetPwd")
    @ResponseBody
    public AjaxResult resetPwd(String strId){
        AjaxResult ajaxResult=new AjaxResult();
        try {
            if (strId.replaceAll("-", "").toString() != null
                    && !"".equals(strId.replaceAll("-", "").toString())) {
                String[] split = strId.split("-");
                for (int i = 0; i < split.length; i++) {
                    adminInfoService.resetPwd(Integer.parseInt(split[i]));
                }
                ajaxResult.setMsg("重置成功");
                return ajaxResult;
            } else {
                ajaxResult.setMsg("至少选择一个管理员");
                return ajaxResult;
            }

        } catch (NumberFormatException e) {
            ajaxResult.setMsg("至少选择一个管理员");
            return ajaxResult;
        }
    }
//高级查询
    @RequestMapping(value = "/findAmdinByCondition")
    @ResponseBody
    public AjaxResult findAmdinByCondition(RoleInfo roleInfo) throws UnsupportedEncodingException {
        roleInfo.setName(URLDecoder.decode(roleInfo.getName(),"UTF-8"));
        AjaxResult ajaxResult=new AjaxResult();
        List<AdminList> adminLists = adminInfoService.getAdminByCondition(roleInfo);
        ajaxResult.setData(adminLists);
        return ajaxResult;
    }
}
