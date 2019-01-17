package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.util.UeditorJson;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by tiziano on 2018/3/2
 * 图片上传接口
 */
public interface UploadImgService {
    /**
     * 普通图片上传
     * @param file
     * @return
     * @throws Exception
     */
    public String upload(MultipartFile file,Long userId,String imagePath) throws Exception;

    public UeditorJson uploadUeditor(MultipartFile file) throws Exception;
}
