package com.xiafei.newsbackend.controller;

import com.xiafei.newsbackend.entity.enu.LogActions;
import com.xiafei.newsbackend.entity.log.LogInfoAddEntity;
import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import com.xiafei.newsbackend.entity.user.UserLoginEntity;
import com.xiafei.newsbackend.service.LogInfoService;
import com.xiafei.newsbackend.service.UserInfoService;
import com.xiafei.newsbackend.util.Constant;
import com.xiafei.newsbackend.util.GetIpAndMac;
import com.xiafei.newsbackend.util.JsonResult;
import com.xiafei.newsbackend.util.MapCache;
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
public class UserInfoController {

    @Autowired
    private UserInfoService service;
    @Autowired
    private LogInfoService logInfoService;


    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    /**
     * 后台登录
     * @param loginEntity
     * @param req
     * @return JsonResult
     * @throws Exception
     * */
    @PostMapping("/login")
    @ResponseBody
    public JsonResult doLogin(@RequestBody @Valid UserLoginEntity loginEntity, HttpServletRequest req){
        /**
         * 读取map缓存,cache是实例常量，本身不可
         * 改变，但容器中存放的对象可以改变
         * */
        MapCache cache = MapCache.single();
        Integer error_count = cache.get("login_error_count");
        try {
            UserInfoEntity user = service.login(loginEntity);
            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            /**
             * 添加系统日志
             * */
            LogInfoAddEntity logInfoAddEntity = new LogInfoAddEntity();
            logInfoAddEntity.setAuthorId(user.getId());
            logInfoAddEntity.setAction(LogActions.LOGIN.getAction());
            logInfoAddEntity.setAddIp(GetIpAndMac.getIp(req));
            logInfoAddEntity.setAddTime(new Date());
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
            return new JsonResult(Constant.FAILED_CODE,Constant.LOGIN_FAILED);
        }
    }

    /**
     * 注销登录
     * @throws Exception
     * @return JsonResult
     * */
    @PostMapping("/logout")
    @ResponseBody
    public JsonResult logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){
            session.removeAttribute("user");
            //重定向到登录页面
            response.sendRedirect("admin/login");
        }
        return new JsonResult(Constant.SUCCESS_CODE,Constant.UNLOGIN_SUCCESS);
    }
}
