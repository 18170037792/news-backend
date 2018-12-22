package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.log.LogInfoAddEntity;
import com.xiafei.newsbackend.entity.log.LogInfoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class LogInfoServiceTest {

    @Autowired
    private LogInfoService service;

    @Test
    public void insertLog() throws Exception{
        LogInfoAddEntity addEntity = new LogInfoAddEntity();
        addEntity.setAction("登录后台");
        addEntity.setAuthorId(1L);
        addEntity.setAddTime(new Date());
        service.insertLog(addEntity);
    }

    @Test
    public void getLogInfo() throws Exception{
        List<LogInfoEntity> logInfoList = service.getLogInfoList(2L);
        System.out.println(logInfoList);
    }
}
