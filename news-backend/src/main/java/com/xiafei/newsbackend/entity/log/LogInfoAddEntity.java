package com.xiafei.newsbackend.entity.log;

import com.xiafei.newsbackend.entity.base.BaseAddEntity;

import java.util.Date;

/**
 * Created by qujie on 2018/12/14
 * */
public class LogInfoAddEntity extends BaseAddEntity {

    /**
     * 用户操作
     * */
    private String action;
    /**
     * 操作数据
     * */
    private String data;
    /**
     * 操作人Id
     * */
    private Long authorId;
    /**
     * ip归属地
     * */
    private String ipHomeLocation;
    /**
     * 最后登录时间
     * */
    private Date lastLoginTime;
    /**
     * 最后登录ip
     * */
    private String lastLoginIp;
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getIpHomeLocation() {
        return ipHomeLocation;
    }

    public void setIpHomeLocation(String ipHomeLocation) {
        this.ipHomeLocation = ipHomeLocation;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
}
