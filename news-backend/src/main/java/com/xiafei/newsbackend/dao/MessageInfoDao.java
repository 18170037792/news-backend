package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.pojo.table.MessageInfoTable;
import org.apache.ibatis.annotations.Param;

public interface MessageInfoDao {

    int addMessage(MessageInfoTable table);

    /**
     * 根据用户id统计评论数
     * @param userId
     * */
    int getCount(@Param("userId") Long userId);
}
