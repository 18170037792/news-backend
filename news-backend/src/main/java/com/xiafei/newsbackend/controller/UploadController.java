package com.xiafei.newsbackend.controller;

import com.xiafei.newsbackend.service.UploadImgService;
import com.xiafei.newsbackend.util.UeditorJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by qujie on 2019/1/9
 * 图片上传控制器
 */
@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController{

    @Autowired
    UploadImgService uploadService;

    /**
     * 用户头像上传
     * */
    @PostMapping("/avatar")
    public void uploadImage(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception{
        /**
         * 获取登录用户信息
         * */
        Long userId = this.getUserId(request, response);
        /**
         * 调用service
         * */
        String upload = uploadService.upload(file,userId,"/upload/image/avatar/");
        /**
         * 重定向个人信息
         * */
        response.sendRedirect("/user/profile");
    }

    /**
     * 文章封面图上传
     * */
    @PostMapping("/cover")
    public void uploadCover() throws Exception{

    }

    /**
     * 富文本图片上传
     * */
    @PostMapping("/ueditor")
    @ResponseBody
    public UeditorJson uploadUeditor(@RequestParam(value = "upfile", required = false) MultipartFile file, HttpServletRequest request) throws Exception {
        /**
         * 文件名称
         */
        UeditorJson json = uploadService.uploadUeditor(file);
        return json;
    }

}
