package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.user.UserLoginEntity;
import com.xiafei.newsbackend.pojo.table.UserInfoTable;
import com.xiafei.newsbackend.pojo.view.UserInfoView;

/**
 * Created by qujie on 2018/12/14
 * */
public interface UserInfoDao {

    UserInfoView login(UserLoginEntity loginEntity);

    int CountUser();
}
