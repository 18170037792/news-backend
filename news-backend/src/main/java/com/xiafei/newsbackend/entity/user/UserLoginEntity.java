package com.xiafei.newsbackend.entity.user;

import com.xiafei.newsbackend.util.Constant;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by qujie on 2018/12/14
 * */
public class UserLoginEntity {

    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为空")
    @Size(min = 1, max = 50, message = Constant.PARAMETER_ERROR)
    private String name;

    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
    @Size(min = 1, max = 20, message = Constant.PARAMETER_ERROR)
    private String pwd;

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
}
