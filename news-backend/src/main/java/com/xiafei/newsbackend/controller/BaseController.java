package com.xiafei.newsbackend.controller;

import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import org.apache.catalina.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by qujie on 2018/12/16
 * 控制器基类,和接口作用类似
 * */
public abstract class BaseController {

    /**
     * 获取请求绑定的登录对象
     * @param request
     * @return
     */
    public UserInfoEntity user(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session == null){
            return null;
        }
        return (UserInfoEntity) session.getAttribute("user");
    }

    /**
     * 获取用户id
     * @param request
     * @return
     * */
    public Long getUserId(HttpServletRequest request){
        Long userId = this.user(request).getId();
        return userId;
    }

}
