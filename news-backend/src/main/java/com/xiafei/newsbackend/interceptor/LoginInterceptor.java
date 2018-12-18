package com.xiafei.newsbackend.interceptor;

import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import com.xiafei.newsbackend.util.InteceptorResultUtil;
import com.xiafei.newsbackend.util.JsonResult;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    public LoginInterceptor(){
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        UserInfoEntity loginUser = (UserInfoEntity) httpServletRequest.getSession().getAttribute("user");
        if(loginUser == null){
            //InteceptorResultUtil.returnResult(httpServletResponse,new JsonResult<>(600,"invalid"));
            httpServletResponse.sendRedirect("/admin/user/toLogin");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
