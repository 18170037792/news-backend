package com.xiafei.newsbackend.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/settings")
public class SettingController {

    @GetMapping("")
    public String settingPage() throws Exception{
        return "user/setting";
    }
}
