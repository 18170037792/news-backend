package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import com.xiafei.newsbackend.entity.user.UserLoginEntity;

public interface UserInfoService {

    UserInfoEntity login(UserLoginEntity loginEntity) throws Exception;
}
