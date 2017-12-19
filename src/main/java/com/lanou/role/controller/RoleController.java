package com.lanou.role.controller;

import com.fasterxml.jackson.databind.Module;
import com.lanou.bean.RoleModule;
import com.lanou.login.bean.AdminInfo;
import com.lanou.role.bean.ModuleId;
import com.lanou.role.bean.RoleInfo;
import com.lanou.role.bean.RoleList;
import com.lanou.role.service.Impl.RoleServiceImpl;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/11.
 * 嗯，这是这个工程唯一的注释
 */
@Controller
public class RoleController {

    @Resource(name = "RoleService")
    private RoleServiceImpl roleService;

    //    主页跳转
    @RequestMapping("/role_info")
    public String indexInfo() {

        return "role/role_list";
    }

    //    获取所有角色
    @RequestMapping(value = "/getRole")
    @ResponseBody
    public AjaxResult getRoleList(HttpSession session) {

        AjaxResult ajaxResult = new AjaxResult();
        List<RoleList> roleInfo = roleService.getRole();
        List<String> roleName = new ArrayList<>();
        for (int i = 0; i < roleInfo.size(); i++) {
            String role_name = roleInfo.get(i).getRole_name();
            roleName.add(role_name);
        }

        session.setAttribute("roleName", roleName);
        ajaxResult.setData(roleInfo);
        return ajaxResult;
    }

    //    添加角色跳转
    @RequestMapping(value = "/addRole")
    public String addRole() {

        return "role/role_add";
    }

    //   添加角色实现函数
    @RequestMapping(value = "/addRoleInfo")
    @ResponseBody
    public AjaxResult addRoleInfo(HttpSession session, RoleInfo roleInfo) {

        AjaxResult ajaxResult = new AjaxResult();
        RoleModule roleModule = new RoleModule();
        List<String> roleName = (List<String>) session.getAttribute("roleName");
        int flag = 0;
        int flag1 = 0;
        for (int i = 0; i < roleName.size(); i++) {
            if (roleName.get(i).equals(roleInfo.getName())) {
                flag = 1;
            }
        }

        for (int i = 0; i < roleInfo.getModuleIdList().size(); i++) {
            if (roleInfo.getModuleIdList().get(i).getMudule_id() != 0) {
                flag1 = 1;
            }
        }
        if (flag == 1) {
            ajaxResult.setErrorCode(404);
            ajaxResult.setMsg("角色名已存在");
            return ajaxResult;
        }

        if (flag1 == 0) {
            ajaxResult.setErrorCode(405);
            ajaxResult.setMsg("至少选择一个权限");
            return ajaxResult;
        }

        roleService.insert(roleInfo);
        RoleInfo roleByName = roleService.getRoleByName(roleInfo);
        roleModule.setRoleId(roleByName.getRoleId());
        for (int i = 0; i < roleInfo.getModuleIdList().size(); i++) {

            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 1) {
                roleModule.setModuleId(1);
                roleService.insert(roleModule);
            }
            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 2) {
                roleModule.setModuleId(2);
                roleService.insert(roleModule);
            }
            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 3) {
                roleModule.setModuleId(3);
                roleService.insert(roleModule);
            }
            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 4) {
                roleModule.setModuleId(4);
                roleService.insert(roleModule);
            }
            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 5) {
                roleModule.setModuleId(5);
                roleService.insert(roleModule);
            }
            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 6) {
                roleModule.setModuleId(6);
                roleService.insert(roleModule);
            }
            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 7) {
                roleModule.setModuleId(7);
                roleService.insert(roleModule);
            }
        }
        ajaxResult.setErrorCode(200);
        return ajaxResult;
    }

    //    删除
    @RequestMapping(value = "/deleteRole")
    @ResponseBody
    public AjaxResult deleteRole(RoleInfo roleinfo) {

        AjaxResult ajaxResult = new AjaxResult();
        int deleteRmNum = roleService.deleteRm(roleinfo.getRoleId());
        int deleteRlNum = roleService.deleteRole(roleinfo);
        List<RoleList> role = roleService.getRole();
        if (deleteRlNum == 1 && deleteRmNum != 0) {
            ajaxResult.setErrorCode(200);
            ajaxResult.setData(role);
        }
        return ajaxResult;
    }

    //    获取当前角色名字id存到Session中
    @RequestMapping(value = "/jumpToUpdate")
    @ResponseBody
    public AjaxResult updateRole(RoleList roleList, HttpSession session) throws UnsupportedEncodingException {

        AjaxResult ajaxResult = new AjaxResult();
        roleList.setRole_name(URLDecoder.decode(roleList.getRole_name(), "UTF-8"));
        roleList.setAccess_info(URLDecoder.decode(roleList.getAccess_info(), "UTF-8"));
        session.setAttribute("roleList", roleList);
        ajaxResult.setErrorCode(200);
        return ajaxResult;
    }

    //   角色管理修改页面的跳转
    @RequestMapping(value = "/toUpdateRole")
    public String toUpdateRole() {
        return "role/role_modi";
    }

    @RequestMapping(value = "/getRoleInfo")
    @ResponseBody
    public AjaxResult getRoleInfo(HttpSession session) {
        AjaxResult ajaxResult = new AjaxResult();
        RoleList roleList = (RoleList) session.getAttribute("roleList");
        ajaxResult.setData(roleList);
        return ajaxResult;
    }

    //   修改角色实现函数
    @RequestMapping(value = "/updateRoleInfo")
    @ResponseBody
    public AjaxResult updateRoleInfo(HttpSession session, RoleInfo roleInfo) {

        AjaxResult ajaxResult = new AjaxResult();
        RoleModule roleModule = new RoleModule();
        List<String> roleName = (List<String>) session.getAttribute("roleName");
        RoleList roleList = (RoleList) session.getAttribute("roleList");
        int flag = 0;
        int flag1 = 0;
        for (int i = 0; i < roleName.size(); i++) {
            if (roleName.get(i).equals(roleInfo.getName())) {
                flag = 1;
            }

        }
        if (roleInfo.getName().equals(roleList.getRole_name())) {
            flag = 0;
        }

        for (int i = 0; i < roleInfo.getModuleIdList().size(); i++) {
            if (roleInfo.getModuleIdList().get(i).getMudule_id() != 0) {
                flag1 = 1;
            }
        }
        if (flag == 1) {
            ajaxResult.setErrorCode(404);
            ajaxResult.setMsg("角色名已存在");
            System.out.println(141146314);
            return ajaxResult;
        }

        if (flag1 == 0) {
            ajaxResult.setErrorCode(405);
            ajaxResult.setMsg("至少选择一个权限");
            return ajaxResult;
        }
        roleInfo.setRoleId(roleList.getRole_id());
        roleService.updateRole(roleInfo);
        roleModule.setRoleId(roleList.getRole_id());
        roleService.deleteRm(roleModule.getRoleId());
        for (int i = 0; i < roleInfo.getModuleIdList().size(); i++) {

            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 1) {
                roleModule.setModuleId(1);
                roleService.insert(roleModule);
            }
            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 2) {
                roleModule.setModuleId(2);
                roleService.insert(roleModule);
            }
            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 3) {
                roleModule.setModuleId(3);
                roleService.insert(roleModule);
            }
            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 4) {
                roleModule.setModuleId(4);
                roleService.insert(roleModule);
            }
            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 5) {
                roleModule.setModuleId(5);
                roleService.insert(roleModule);
            }
            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 6) {
                roleModule.setModuleId(6);
                roleService.insert(roleModule);
            }
            if (roleInfo.getModuleIdList().get(i).getMudule_id() == 7) {
                roleModule.setModuleId(7);
                roleService.insert(roleModule);
            }
        }
        ajaxResult.setErrorCode(200);
        return ajaxResult;
    }
}
