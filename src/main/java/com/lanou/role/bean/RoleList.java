package com.lanou.role.bean;

import java.util.List;

/**
 * Created by dllo on 17/12/11.
 * 嗯，这是这个工程唯一的注释
 */
public class RoleList {

    private Integer role_id;
    private String role_name;
    private String access_info;



    public RoleList() {
    }

    @Override
    public String toString() {
        return "RoleList{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", access_info='" + access_info + '\'' +
                '}';
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getAccess_info() {
        return access_info;
    }

    public void setAccess_info(String access_info) {
        this.access_info = access_info;
    }

}
