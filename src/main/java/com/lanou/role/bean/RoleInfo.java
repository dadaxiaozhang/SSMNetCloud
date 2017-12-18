package com.lanou.role.bean;

import java.util.List;

public class RoleInfo {
    private Integer roleId;

    private String name;

    private List<ModuleId> moduleIdList;

    public RoleInfo() {
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<ModuleId> getModuleIdList() {
        return moduleIdList;
    }

    public void setModuleIdList(List<ModuleId> moduleIdList) {
        this.moduleIdList = moduleIdList;
    }
}