package com.xiafei.newsbackend.entity.base;

import java.util.Date;

/**
 * Created by qujie on 2018/12/10
 * */
public class BaseModifyEntity {

    private Long id;
    private Date modifyTime;
    private Long modifyUser;
    private String modifyIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getModifyIp() {
        return modifyIp;
    }

    public void setModifyIp(String modifyIp) {
        this.modifyIp = modifyIp;
    }
}
