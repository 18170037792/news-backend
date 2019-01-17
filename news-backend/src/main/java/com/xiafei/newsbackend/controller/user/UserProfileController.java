package com.xiafei.newsbackend.controller.user;

import com.xiafei.newsbackend.controller.BaseController;
import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import com.xiafei.newsbackend.service.UserInfoService;
import com.xiafei.newsbackend.util.Constant;
import com.xiafei.newsbackend.util.GetMD5;
import com.xiafei.newsbackend.util.JsonResult;
import com.xiafei.newsbackend.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by qujie on 2018/1/4
 * 用户个人信息控制器
 * */
@Controller
@RequestMapping("/user")
public class UserProfileController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/profile")
    public String profile(HttpServletRequest request,HttpServletResponse response) throws Exception {
        /**
         * 获取登录人id
         * */
        Long userId = this.getUserId(request, response);
        UserInfoEntity userInfoEntity = userInfoService.getUserByAuthorId(userId);

        request.setAttribute("profile",userInfoEntity);
        return "user/profile";
    }

    @PostMapping("/updatePwd")
    @ResponseBody
    public JsonResult updatePwd(@RequestParam String oldPwd,@RequestParam String newPwd,
                                HttpServletRequest request, HttpServletResponse response) throws Exception{
        UserInfoEntity user = this.getUser(request, response);
        /**
         * 字段验证
         * */
        if(ValidateUtil.isNull(oldPwd) || ValidateUtil.isNull(newPwd)){
            return new JsonResult(Constant.FAILED_CODE,Constant.FULL_VALIDATION);
        }
        if(!userInfoService.getOldPwd(user.getId()).equals(GetMD5.getMD5(oldPwd))){
            return new JsonResult(Constant.FAILED_CODE,Constant.PWD_NOT_LIKE);
        }
        if(oldPwd.equals(newPwd)){
            return new JsonResult(Constant.FAILED_CODE,Constant.NOT_THE_SAME);
        }
        if(newPwd.length() <6 || newPwd.length() >14){
            return new JsonResult(Constant.FAILED_CODE,Constant.PWD_LENGTH_ERROR);
        }
        /**
         * 修改密码
         * */
        userInfoService.updatePwd(user.getId(),newPwd);
        return new JsonResult(Constant.SUCCESS_CODE,Constant.UPDATE_SUCCESS);
    }
}
