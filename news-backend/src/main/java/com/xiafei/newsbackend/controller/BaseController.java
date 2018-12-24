package com.xiafei.newsbackend.controller;

import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import org.apache.catalina.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by qujie on 2018/12/16
 * 控制器基类,和接口作用类似
 * */
public abstract class BaseController {

    /**
     * 获取登录用户对象
     * @param request
     * @return
     */
    public UserInfoEntity getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if(session == null){
            response.sendRedirect("/admin/user/login");
        }
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        return user;
    }

    /**
     * 获取登录的管理员对象
     * */
    public UserInfoEntity getAdminUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if(session == null){
            response.sendRedirect("/admin/user/login");
        }
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("admin");
        return user;
    }

    /**
     * 获取用户id
     * @param request
     * @return
     * */
    public Long getUserId(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Long userId = this.getUser(request,response).getId();
        return userId;
    }

    /**
     * 获取管理员id
     * @param request
     * @return
     * */
    public Long getAdminUserId(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Long userId = this.getAdminUser(request, response).getId();
        return userId;
    }
}
