package com.xiafei.newsbackend.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qujie on 2018/12/25
 * 用户管理控制器
 * */
@Controller
@RequestMapping("/admin/user")
public class UserManageController {

    @GetMapping("/list")
    public String userList(){
        return "admin/user_list";
    }
}
