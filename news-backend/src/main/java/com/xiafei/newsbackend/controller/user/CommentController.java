package com.xiafei.newsbackend.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/comments")
public class CommentController {

    @GetMapping("")
    public String commentPage() throws Exception{
        return "user/comment_list";
    }
}
