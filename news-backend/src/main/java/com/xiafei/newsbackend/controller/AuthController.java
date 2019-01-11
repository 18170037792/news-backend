package com.xiafei.newsbackend.controller;

import com.xiafei.newsbackend.entity.enu.LogActions;
import com.xiafei.newsbackend.entity.log.LogInfoAddEntity;
import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import com.xiafei.newsbackend.entity.user.UserLoginEntity;
import com.xiafei.newsbackend.service.LogInfoService;
import com.xiafei.newsbackend.service.UserInfoService;
import com.xiafei.newsbackend.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/admin/user")
public class AuthController extends BaseController{

    @Autowired
    private UserInfoService service;
    @Autowired
    private LogInfoService logInfoService;

    /**
     * 跳转到登录页面
     * */
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    /**
     * 后台登录
     * @param name
     * @param pwd
     * @param req
     * @return JsonResult
     * @throws Exception
     * */
    @PostMapping("/login")
    @ResponseBody
    public JsonResult doLogin(@RequestParam String name,@RequestParam String pwd,HttpServletRequest req) throws Exception {
        UserLoginEntity loginEntity = new UserLoginEntity();
        loginEntity.setName(name);
        loginEntity.setPwd(pwd);
        /**
         * 读取map缓存,cache是实例常量，本身不可
         * 改变，但容器中存放的对象可以改变
         * */
        MapCache cache = MapCache.single();
        Integer error_count = cache.get("login_error_count");
        try {
            UserInfoEntity user = service.login(loginEntity);
            HttpSession session = req.getSession();

            /**
             * 判断权限
             * */
            if(user.getRoleId() == null || user.getFrozen() == 1){
                return new JsonResult(Constant.FAILED_CODE,Constant.AUTH_ERROR);
            }else if (user.getRoleId() == 1){
                session.setAttribute("user",user);
                session.setMaxInactiveInterval(60*60);
            }else if (user.getRoleId() == 2){
                session.setAttribute("admin",user);
                session.setMaxInactiveInterval(60*60);
                return new JsonResult(Constant.ADMIN_CODE,Constant.LOGIN_SUCCESS,user);
            }

            /**
             * 添加系统日志
             * */
            LogInfoAddEntity logInfoAddEntity = new LogInfoAddEntity();
            logInfoAddEntity.setAuthorId(user.getId());
            logInfoAddEntity.setAction(LogActions.LOGIN.getAction());
            logInfoAddEntity.setIpHomeLocation(AddressUtils.getIpDescr(GetIpAndMac.getIp(req)));
            logInfoAddEntity.setLastLoginIp(GetIpAndMac.getIp(req));
            logInfoAddEntity.setLastLoginTime(new Date());

            logInfoService.insertLog(logInfoAddEntity);
            return new JsonResult(Constant.SUCCESS_CODE,Constant.LOGIN_SUCCESS,user);
        } catch (Exception e) {
            /**
             * 三元表达式，缓存中error为null
             * 的条件下赋值1，否则赋值+1
             * */
            error_count = null == error_count ? 1 : error_count + 1;
            if (error_count > 3) {
                return new JsonResult(Constant.FAILED_CODE,Constant.NUMBER_IS_BEYOND);
            }
            cache.set("login_error_count", error_count, 10 * 60);
            return new JsonResult(Constant.FAILED_CODE,Constant.LOGIN_ERROR);
        }
    }

    /**
     * 注销登录，
     * 不需要重定向，session清除后会被拦截器拦截到登录页面
     * @throws Exception
     * @return JsonResult
     * */
    @GetMapping("/logout")
    public void logout(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            if(session.getAttribute("admin") != null){
                session.removeAttribute("admin");
            }
        }else {
            UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
            /**
             * 添加系统日志
             * */
            LogInfoAddEntity logInfoAddEntity = new LogInfoAddEntity();
            logInfoAddEntity.setAuthorId(user.getId());
            logInfoAddEntity.setAction(LogActions.LOGOUT.getAction());
            logInfoAddEntity.setIpHomeLocation(AddressUtils.getIpDescr(GetIpAndMac.getIp(request)));
            logInfoAddEntity.setLastLoginIp(GetIpAndMac.getIp(request));
            logInfoAddEntity.setLastLoginTime(new Date());

            logInfoService.insertLog(logInfoAddEntity);

            session.removeAttribute("user");
        }

    }

}
