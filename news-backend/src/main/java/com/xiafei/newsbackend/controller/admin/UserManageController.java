package com.xiafei.newsbackend.controller.admin;

import com.xiafei.newsbackend.entity.user.UserInfoUpdateEntity;
import com.xiafei.newsbackend.entity.user.UserLogEntity;
import com.xiafei.newsbackend.service.UserInfoService;
import com.xiafei.newsbackend.util.Constant;
import com.xiafei.newsbackend.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by qujie on 2018/12/25
 * 用户管理控制器
 * */
@Controller
@RequestMapping("/admin/user")
public class UserManageController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/list")
    public String userList(HttpServletRequest request) throws Exception {
        List<UserLogEntity> entities = userInfoService.getUserList();

        request.setAttribute("users",entities);
        return "admin/user_list";
    }

    /**
     * 冻结用户
     * @param id
     * @param frozen
     * @throws Exception
     * */
    @PostMapping("/freeze")
    public JsonResult freezeUser(Long id,Integer frozen) throws Exception {
        UserInfoUpdateEntity updateEntity = new UserInfoUpdateEntity();
        updateEntity.setId(id);
        updateEntity.setFrozen(frozen);
        updateEntity.setModifyTime(new Date());
        userInfoService.frozenUser(updateEntity);
        return new JsonResult(Constant.SUCCESS_CODE,Constant.UPDATE_SUCCESS);
    }

    /**
     * 启用用户
     * @param id
     * @param frozen
     * @throws Exception
     * */
    @PostMapping("/open")
    public JsonResult openUser(Long id,Integer frozen) throws Exception{
        UserInfoUpdateEntity updateEntity = new UserInfoUpdateEntity();
        updateEntity.setId(id);
        updateEntity.setFrozen(frozen);
        updateEntity.setModifyTime(new Date());
        userInfoService.frozenUser(updateEntity);
        return new JsonResult(Constant.SUCCESS_CODE,Constant.UPDATE_SUCCESS);
    }
}
