package com.xiafei.newsbackend.interceptor;

import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import com.xiafei.newsbackend.util.Common;
import com.xiafei.newsbackend.util.InteceptorResultUtil;
import com.xiafei.newsbackend.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by qujie on 2018/12/16
 * 自定义拦截器
 */
@Component
public class BaseInterceptor implements HandlerInterceptor {

    @Resource
    private Common common;

    /**
     * 登录拦截
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        UserInfoEntity loginUser = (UserInfoEntity) request.getSession().getAttribute("user");
        if(loginUser == null){
            InteceptorResultUtil.returnResult(response,new JsonResult<>(600,"invalid"));
            return false;
        }
        return true;
    }

    /**
     * 一些工具类和公共方法
     * */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        httpServletRequest.setAttribute("common", common);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
