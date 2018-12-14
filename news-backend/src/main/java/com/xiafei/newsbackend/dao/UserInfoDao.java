package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.user.UserLoginEntity;
import com.xiafei.newsbackend.pojo.table.UserInfoTable;

/**
 * Created by qujie on 2018/12/14
 * */
public interface UserInfoDao {

    UserInfoTable login(UserLoginEntity loginEntity);
}
