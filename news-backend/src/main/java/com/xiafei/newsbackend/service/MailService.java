package com.xiafei.newsbackend.service;

import java.io.File;
import java.util.List;

/**
 * Created by qujie on 2019/2/12
 * 邮件发送服务
 * */
public interface MailService {

    void sendSimpleMail(String to,String title,String content);

    void sendAttachmentsMail(String to, String title, String cotent, List<File> fileList);

}
