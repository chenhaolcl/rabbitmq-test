package cn.ch.controller;

import cn.ch.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname EmailController
 * @Description 发送邮件
 * @create 2021/2/2
 * @Author random
 */
@RestController
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("mail")
    public ServerResponse send(){

        SimpleMailMessage message = new SimpleMailMessage();
        //发件人
        message.setFrom("13676623960@163.com");
        message.setTo("yt4259@126.com");
        message.setSubject("springboot发送邮件");
        message.setText("邮件内容");
        message.setCc("920988438@qq.com");
        mailSender.send(message);
        return ServerResponse.success();
    }
}
