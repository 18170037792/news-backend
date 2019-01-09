package com.xiafei.newsbackend.controller;

import com.xiafei.newsbackend.service.UploadImgService;
import com.xiafei.newsbackend.util.UeditorJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by qujie on 2019/1/9
 * 图片上传控制器
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    UploadImgService uploadService;

    @PostMapping("/ueditor")
    public UeditorJson uploadUeditor(@RequestParam(value = "upfile", required = false) MultipartFile file, HttpServletRequest request) throws Exception {
        /**
         * 文件名称
         */
        UeditorJson json = uploadService.uploadUeditor(file);
        return json;
    }

}
