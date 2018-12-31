package com.xiafei.newsbackend.controller.admin;

import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import com.xiafei.newsbackend.entity.user.UserInfoUpdateEntity;
import com.xiafei.newsbackend.service.UserInfoService;
import com.xiafei.newsbackend.util.Constant;
import com.xiafei.newsbackend.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by qujie on 2018/12/25
 * 用户管理信息控制器
 * */
@Controller
@RequestMapping("/admin/user")
public class UserManageController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 用户分页列表
     * @param current 当前页
     * @param row 分页条数
     * */
    @GetMapping("/list")
    public String userList(@RequestParam(value = "current", defaultValue = "1") int current,
                           @RequestParam(value = "row", defaultValue = "7") int row, HttpServletRequest request) throws Exception {
        PageShowEntity<UserInfoEntity> pageShowEntity = userInfoService.getUserWithPage(current, row);
        request.setAttribute("users",pageShowEntity);
        return "admin/user_list";
    }

    /**
     * 冻结用户
     * @param id
     * @param frozen
     * @throws Exception
     * */
    @PostMapping("/freeze")
    @ResponseBody
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
    @ResponseBody
    public JsonResult openUser(Long id,Integer frozen) throws Exception{
        UserInfoUpdateEntity updateEntity = new UserInfoUpdateEntity();
        updateEntity.setId(id);
        updateEntity.setFrozen(frozen);
        updateEntity.setModifyTime(new Date());
        userInfoService.frozenUser(updateEntity);
        return new JsonResult(Constant.SUCCESS_CODE,Constant.UPDATE_SUCCESS);
    }
}
