package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.pojo.table.LogInfoTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class LogInfoDaoTest {

    @Autowired
    private LogInfoDao dao;

    @Test
    public void insertLog(){
        LogInfoTable table = new LogInfoTable();
        table.setAction("登录后台");
        table.setAuthorId(1L);
        table.setAddTime(new Date());
        int result = dao.insertLog(table);
        if(result == 0){
            System.out.println("新增失败");
        }
    }
}
