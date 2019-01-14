package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.message.MessageInfoSearchEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.pojo.table.MessageInfoTable;
import com.xiafei.newsbackend.pojo.view.MessageArticleView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageInfoDaoTest {

    @Autowired
    private MessageInfoDao dao;

    @Test
    public void addMessage(){
        MessageInfoTable table = new MessageInfoTable();
        table.setName("瞿杰");
        table.setEmail("1071367833@qq.com");
        table.setWebSiteUrl("http://www.qujiework.cn");
        table.setTitle("测试");
        table.setContent("测试dao层");
        table.setAddTime(new Date());
        int count = dao.addMessage(table);
        if(count == 1){
            System.out.println("新增成功");
        }else {
            System.out.println("新增失败");
        }
    }

    @Test
    public void getCount(){
        int count = dao.getCount(1L);
        System.out.println(count);
    }

    /**
     * 根据用户id获取后台留言管理分页列表
     * */
    @Test
    public void getMessagePageList(){
        MessageInfoSearchEntity searchEntity = new MessageInfoSearchEntity();
        searchEntity.setUserId(1L);
        PageLimitEntity limitEntity = new PageLimitEntity();
        limitEntity.setCurrent(1);
        limitEntity.setRow(7);
        searchEntity.setLimitEntity(limitEntity);
        List<MessageArticleView> views = dao.getMessagePageList(searchEntity);
        System.out.println(views);
    }
}
