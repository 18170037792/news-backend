package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.entity.user.*;
import com.xiafei.newsbackend.pojo.table.UserInfoTable;

import java.util.List;

public interface UserInfoService {

    UserInfoEntity login(UserLoginEntity loginEntity) throws Exception;

    List<UserLogEntity> getUserList(PageLimitEntity limitEntity) throws Exception;

    void frozenUser(UserInfoUpdateEntity updateEntity) throws Exception;

    PageShowEntity<UserInfoEntity> getUserWithPage(int current,int row) throws Exception;

    /**
     * 根据作者id查询作者信息
     * @param authorId
     * @throws Exception
     * */
    UserInfoEntity getUserByAuthorId(Long authorId) throws Exception;

    /**
     * 根据用户id获取原密码
     * @param id
     * @throws Exception
     * */
    String getOldPwd(Long id) throws Exception;

    /**
     * 修改密码
     * @param id 用户id
     * @param newPwd 新密码
     * @throws Exception
     * */
    void updatePwd(Long id,String newPwd) throws Exception;

    /**
     * 修改用户信息
     * @param entity
     * @throws Exception
     * */
    void updateUser(UserInfoEntity entity) throws Exception;

    /**
     * 用户注册
     * @param registerEntity
     * @throws Exception
     * */
    void register(UserRegisterEntity registerEntity) throws Exception;
}
