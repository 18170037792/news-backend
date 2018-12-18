package com.xiafei.newsbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @RequestMapping("/contact")
    public String contact(){
        return "home/contact";
    }

    @RequestMapping("/about")
    public String about(){
        return "home/about";
    }

    @RequestMapping("/index")
    public String index(){
        return "home/index";
    }

    @RequestMapping("/single")
    public String single(){
        return "home/single";
    }

    @RequestMapping("/admin/index")
    public String amdin(){
        return "admin/index";
    }
}
