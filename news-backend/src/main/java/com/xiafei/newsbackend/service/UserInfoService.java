package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import com.xiafei.newsbackend.entity.user.UserInfoUpdateEntity;
import com.xiafei.newsbackend.entity.user.UserLogEntity;
import com.xiafei.newsbackend.entity.user.UserLoginEntity;

import java.util.List;

public interface UserInfoService {

    UserInfoEntity login(UserLoginEntity loginEntity) throws Exception;

    List<UserLogEntity> getUserList(PageLimitEntity limitEntity) throws Exception;

    void frozenUser(UserInfoUpdateEntity updateEntity) throws Exception;

    PageShowEntity<UserInfoEntity> getUserWithPage(int current,int row) throws Exception;
}
