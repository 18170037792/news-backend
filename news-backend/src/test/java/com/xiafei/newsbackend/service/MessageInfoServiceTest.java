package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.message.MessageArticleEntity;
import com.xiafei.newsbackend.entity.message.MessageInfoSearchEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by qujie on 2018/1/14
 * 留言管理业务层测试
 * */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageInfoServiceTest {

    @Autowired
    private MessageInfoService messageInfoService;

    @Test
    public void getMessageWithPage() throws Exception{
        MessageInfoSearchEntity searchEntity = new MessageInfoSearchEntity();
        searchEntity.setUserId(1L);
        PageLimitEntity limitEntity = new PageLimitEntity();
        limitEntity.setCurrent(1);
        limitEntity.setRow(3);
        searchEntity.setLimitEntity(limitEntity);
        PageShowEntity<MessageArticleEntity> showEntity = messageInfoService.getMessageWithPage(searchEntity);
        System.out.println(showEntity);
    }
}