package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.pojo.table.LinksInfoTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class LinksInfoDaoTest {

    @Autowired
    LinksInfoDao dao;

    @Test
    public void insert(){
        LinksInfoTable pojo = new LinksInfoTable();
        pojo.setName("facebook");
        pojo.setLinkAddress("https://www.facebook.com");
        pojo.getLinkAddress().length();
        pojo.setSort(0);
        pojo.setAddTime(new Date());
        int result = dao.insert(pojo);
        if(result < 1){
            System.out.println("添加失败");
        }else if(result == 1){
            System.out.println("添加成功");
        }
    }

    @Test
    public void list(){
        List<LinksInfoTable> list = dao.getList();
        System.out.println(list);
    }
}
