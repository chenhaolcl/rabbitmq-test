package cn.ch.service.impl;

import cn.ch.service.MailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * @Classname MailServiceImpl
 * @Description
 * @create 2021/2/5
 * @Author random
 */
@Service
public class MailServiceImpl implements MailService{

    @Override
    public SimpleMailMessage createMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        //发件人
        message.setFrom("13676623960@163.com");
        message.setTo("yt4259@126.com");
        message.setSubject("springboot发送邮件");
        message.setText("邮件内容");
        message.setCc("920988438@qq.com");
        return message;
    }
}
