package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.NewsBackendApplicationTests;
import com.xiafei.newsbackend.service.MailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

@Component
public class MailServiceImplTest extends NewsBackendApplicationTests {

    @Autowired
    private MailService mailService;

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("1521778314@qq.com","代码测试","天冷了注意保暖");
    }
}