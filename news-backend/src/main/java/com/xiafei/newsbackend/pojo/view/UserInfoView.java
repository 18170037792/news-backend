package com.xiafei.newsbackend.pojo.view;

import java.util.Date;

public class UserInfoView {

    private Long id;

    /**
     * 用户名
     * */
    private String name;
    /**
     * 密码
     * */
    private String pwd;
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
     * 角色ID
     * */
    private Long roleId;
    /**
     * 用户主页
     * */
    private String homeUrl;
    /**
     * 最后登录时间
     * */
    private Date lastLoginTime;
    /**
     * 最后登录ip地址
     * */
    private String lastLoginIp;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Override
    public String toString() {
        return "UserInfoView{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", mobile='" + mobile + '\'' +
                ", frozen=" + frozen +
                ", email='" + email + '\'' +
                ", roleId=" + roleId +
                ", homeUrl='" + homeUrl + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                '}';
    }
}
