package com.xiafei.newsbackend.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/article")
public class ArticleInfoController {

    @RequestMapping("/publish")
    public String article(){
        return "user/article_edit";
    }

    /**
     * 文章分页列表
     * @param current 当前页
     * @param row 分页条数
     * @throws Exception
     * */
    @RequestMapping("/list")
    public String articleList(@RequestParam(value = "current", defaultValue = "1") int current,
                       @RequestParam(value = "row", defaultValue = "7") int row, HttpServletRequest request) throws Exception{

        return "user/article_list";
    }
}
