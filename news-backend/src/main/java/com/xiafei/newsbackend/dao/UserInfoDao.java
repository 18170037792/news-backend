package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.user.UserLoginEntity;
import com.xiafei.newsbackend.pojo.table.UserInfoTable;
import com.xiafei.newsbackend.pojo.view.UserInfoView;
import com.xiafei.newsbackend.pojo.view.UserLogView;

import java.util.List;

/**
 * Created by qujie on 2018/12/14
 * */
public interface UserInfoDao {

    UserInfoView login(UserLoginEntity loginEntity);

    int CountUser();

    /**
     * 拉取用户列表
     * */
    List<UserLogView> getUserList();

    /**
     * 用户冻结与启用
     * @param table
     * */
    int updateFrozen(UserInfoTable table);
}
