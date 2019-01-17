package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.message.MessageInfoSearchEntity;
import com.xiafei.newsbackend.pojo.table.MessageInfoTable;
import com.xiafei.newsbackend.pojo.view.MessageArticleView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageInfoDao {

    int addMessage(MessageInfoTable table);

    /**
     * 根据用户id统计评论数
     * @param userId
     * */
    int getCount(@Param("userId") Long userId);

    /**
     * 根据用户id获取后台留言管理分页列表
     * @param searchEntity
     * */
    List<MessageArticleView> getMessagePageList(MessageInfoSearchEntity searchEntity);

    /**
     * 修改留言状态
     * @param table
     * */
    int update(MessageInfoTable table);

    /**
     * 根据id查询留言是否存在
     * */
    int isExist(@Param("id") Long id);

    /**
     * 删除单个留言状态
     * @param
     * */
    int delete(@Param("id") Long id);
}
