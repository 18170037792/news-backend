package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.user.UserLoginEntity;
import com.xiafei.newsbackend.pojo.table.UserInfoTable;
import com.xiafei.newsbackend.pojo.view.UserInfoView;
import com.xiafei.newsbackend.pojo.view.UserLogView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qujie on 2018/12/14
 * */
public interface UserInfoDao {

    UserInfoView login(UserLoginEntity loginEntity);

    /**
     * 分页数据统计
     * */
    int countUserList();

    /**
     * 拉取用户分页列表
     * */
    List<UserLogView> getUserList(PageLimitEntity limitEntity);

    /**
     * 用户冻结与启用
     * @param table
     * */
    int updateFrozen(UserInfoTable table);

    /**
     * 根据作者id查询作者信息
     * @param
     * */
    UserInfoTable getUserByAuthorId(@Param("authorId") Long authorId);
}
