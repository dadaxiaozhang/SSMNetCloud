package com.lanou.role.bean;

/**
 * Created by dllo on 17/12/12.
 * 嗯，这是这个工程唯一的注释
 */
public class ModuleId {
    private Integer mudule_id;


    public ModuleId() {
    }

    public ModuleId(Integer mudule_id) {
        this.mudule_id = mudule_id;
    }

    @Override
    public String toString() {
        return "ModuleId{" +
                "mudule_id=" + mudule_id +
                '}';
    }

    public Integer getMudule_id() {
        return mudule_id;
    }

    public void setMudule_id(Integer mudule_id) {
        this.mudule_id = mudule_id;
    }
}
