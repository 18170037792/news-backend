package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.links.LinksInfoAddEntity;
import com.xiafei.newsbackend.entity.links.LinksInfoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class LinksInfoServiceTest {

    @Autowired
    private LinksInfoService service;

    @Test
    public void insert() throws Exception{
        LinksInfoAddEntity entity = new LinksInfoAddEntity();
        entity.setName("新浪新闻");
        entity.setLinkAddress("https://news.sina.com.cn/");
        entity.setSort(2);
        entity.setAddTime(new Date());
        service.insert(entity);
    }

    @Test
    public void list() throws Exception{
        List<LinksInfoEntity> list = service.getList();
        System.out.println(list);
    }
}
