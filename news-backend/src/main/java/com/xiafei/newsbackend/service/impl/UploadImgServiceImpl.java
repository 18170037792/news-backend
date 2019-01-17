package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.dao.UserInfoDao;
import com.xiafei.newsbackend.pojo.table.UserInfoTable;
import com.xiafei.newsbackend.service.UploadImgService;
import com.xiafei.newsbackend.util.GetMD5;
import com.xiafei.newsbackend.util.GetRandom;
import com.xiafei.newsbackend.util.UeditorJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

/**
 * Created by tiziano on 2018/3/2
 * 图片上传实现类
 * 绝对路径和相对路径的两种上传方式
 */
@Service
public class UploadImgServiceImpl implements UploadImgService {
    Logger logger = LoggerFactory.getLogger(UploadImgServiceImpl.class);

    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * 普通图片上传
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String upload(MultipartFile file,Long userId,String imagePath) throws Exception {

        /**
         * 获取jar包所在的资源路径
         * */
        String path = ResourceUtils.getFile("classpath:static/").getPath();

        /**
         * 获取文件名
         */
        String fileName = file.getOriginalFilename();
        /**
         * 获取文件的后缀名
         */
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        /**
         * 重新赋值文件名
         * */
        fileName = GetMD5.getMD5(fileName.substring(fileName.indexOf(".")-1) + "image"+ GetRandom.getRandom())+ UUID.randomUUID()+suffixName;

        File dest = new File(path + imagePath + fileName);
        /**
         * 检测是否存在目录
         */
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);

        /**
         * 保存图片信息
         * */
        UserInfoTable userInfoTable = new UserInfoTable();
        userInfoTable.setId(userId);
        userInfoTable.setAvatar("http://localhost:8083"+ imagePath + fileName);
        userInfoDao.updateUser(userInfoTable);

        return fileName;
    }

    /**
     * 富文本图片上传
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UeditorJson uploadUeditor(MultipartFile file) throws Exception {

        /**
         * 获取jar包所在的资源路径
         * */
        String path = ResourceUtils.getFile("classpath:static/").getPath();

        UeditorJson json = new UeditorJson();

        /**
         * 获取文件名
         */
        String fileName = file.getOriginalFilename();
        /**
         * 获取文件的后缀名
         */
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = GetMD5.getMD5(fileName.substring(fileName.indexOf(".")-1) + System.currentTimeMillis())+ UUID.randomUUID()+suffixName;

        File dest = new File(path +"/upload/image/"+ fileName);
        /**
         * 检测是否存在目录
         */
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);

        /**
         * 返回正确的json
         * */
        json.setState("SUCCESS");
        json.setUrl(fileName);
        json.setOriginal(fileName);
        json.setTitle(fileName);

        return json;

    }

}
