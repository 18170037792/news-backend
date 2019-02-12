package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.util.List;

/**
 * Created by qujie on 2019/2/12
 * 邮件发送服务实现
 * */
@Service
public class MailServiceImpl implements MailService {

    //发送方
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 邮件发送文本
     * @param to 接收方
     * @param title
     * @param content
     * */
    @Override
    public void sendSimpleMail(String to, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        javaMailSender.send(message);
        logger.info("邮件发送成功");
    }

    /**
     * 邮件发送附件
     * @param to
     * @param title
     * @param cotent
     * @param fileList 附件列表
     * */
    @Override
    public void sendAttachmentsMail(String to, String title, String cotent, List<File> fileList) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(title);
            helper.setText(cotent);
            String fileName = null;
            for (File file:fileList) {
                fileName = MimeUtility.encodeText(file.getName(), "GB2312", "B");
                helper.addAttachment(fileName, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
        logger.info("邮件发送成功");
    }
}
