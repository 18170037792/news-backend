package com.xiafei.newsbackend.pojo.view;

import java.util.Date;

/**
 * Created by qujie on 2018/12/25
 * 用户管理关联实体
 * */
public class UserLogView {

    private Long id;
    /**
     * 用户名
     * */
    private String name;
    /**
     * 手机号
     * */
    private String mobile;
    /**
     * 是否冻结
     * */
    private Integer frozen;
    /**
     * 邮箱
     * */
    private String email;
    /**
     * 用户主页
     * */
    private String homeUrl;

    /**
     * 最后登录时间
     * */
    private Date lastLoginTime;
    /**
     * 最后登录地点
     * */
    private String ipHomeLocation;
    /**
     * 用户动作
     * */
    private String action;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getFrozen() {
        return frozen;
    }

    public void setFrozen(Integer frozen) {
        this.frozen = frozen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getIpHomeLocation() {
        return ipHomeLocation;
    }

    public void setIpHomeLocation(String ipHomeLocation) {
        this.ipHomeLocation = ipHomeLocation;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "UserLogView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", frozen=" + frozen +
                ", email='" + email + '\'' +
                ", homeUrl='" + homeUrl + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", ipHomeLocation='" + ipHomeLocation + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
