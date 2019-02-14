package com.xiafei.newsbackend.entity.user;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by qujie on 2019/2/11
 * 用户注册实体类
 * */
public class UserRegisterEntity {

    @NotNull(message = "账号不能为空")
    @NotBlank(message = "账号不能为空")
    private String name;
    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
    private String pwd;
    @NotNull(message = "邮箱不能为空")
    @NotBlank(message = "邮箱不能为空")
    private String email;
    private Date addTime;
    private String addIp;

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public String getPwd() {
        return pwd;
    }

    public void setPwd(@NotNull String pwd) {
        this.pwd = pwd;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }
}
