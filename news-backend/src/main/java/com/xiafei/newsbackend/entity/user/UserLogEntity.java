package com.xiafei.newsbackend.entity.user;

import java.io.Serializable;
import java.util.Date;

public class UserLogEntity implements Serializable {

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

    @Override
    public String toString() {
        return "UserLogEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", frozen=" + frozen +
                ", email='" + email + '\'' +
                ", homeUrl='" + homeUrl + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", ipHomeLocation='" + ipHomeLocation + '\'' +
                '}';
    }
}
