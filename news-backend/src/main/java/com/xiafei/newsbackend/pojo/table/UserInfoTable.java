package com.xiafei.newsbackend.pojo.table;

import java.util.Date;

/**
 * Created by qujie on 2018/12/14
 * */
public class UserInfoTable extends BaseTable{

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

    @Override
    public String toString() {
        return "UserInfoTable{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", mobile='" + mobile + '\'' +
                ", frozen=" + frozen +
                ", email='" + email + '\'' +
                ", roleId=" + roleId +
                ", homeUrl='" + homeUrl + '\'' +
                '}';
    }
}
