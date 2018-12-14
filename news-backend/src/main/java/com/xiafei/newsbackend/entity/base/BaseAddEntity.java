package com.xiafei.newsbackend.entity.base;

import java.util.Date;

/**
 * Created by qujie on 2018/12/10
 * 新增实体类基类
 * */
public class BaseAddEntity {

    private Date addTime;
    private Long addUser;
    private String addIp;

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getAddUser() {
        return addUser;
    }

    public void setAddUser(Long addUser) {
        this.addUser = addUser;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }
}
