package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.message.MessageArticleEntity;
import com.xiafei.newsbackend.entity.message.MessageInfoSearchEntity;
import com.xiafei.newsbackend.entity.message.MessageInfoUpdateEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;

/**
 * Created by qujie on 2019/1/14
 * */
public interface MessageInfoService {

    /**
     * 根据用户id获取后台留言管理分页列表
     * @param searchEntity
     * @throws Exception
     * @return PageShowEntity
     * */
    PageShowEntity<MessageArticleEntity> getMessageWithPage(MessageInfoSearchEntity searchEntity) throws Exception;

    /**
     * 修改留言信息
     * @param updateEntity
     * */
    void updateMessage(MessageInfoUpdateEntity updateEntity) throws Exception;

    /**
     * 删除单条留言信息
     * @param id
     * @throws Exception
     * */
    void delComment(Long id) throws Exception;
}
