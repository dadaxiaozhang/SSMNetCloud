package com.lanou.admin.bean;

import java.sql.Date;

/**
 * Created by dllo on 17/12/15.
 * 嗯，这是这个工程唯一的注释
 */
public class AdminList {

    private Integer admin_id;

    private String admin_code;

    private String password;

    private String name;

    private String telephone;

    private String email;

    private Date enrolldate;

    private Integer role_id;
    private String role_name;
    private String access_info;

    public AdminList() {
    }

    @Override
    public String toString() {
        return "AdminList{" +
                "admin_id=" + admin_id +
                ", admin_code='" + admin_code + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enrolldate=" + enrolldate +
                ", role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", access_info='" + access_info + '\'' +
                '}';
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_code() {
        return admin_code;
    }

    public void setAdmin_code(String admin_code) {
        this.admin_code = admin_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Date enrolldate) {
        this.enrolldate = enrolldate;
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
