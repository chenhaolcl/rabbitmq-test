package cn.ch.controller;

import cn.ch.service.MailService;
import cn.ch.utils.JsonUtils;
import cn.ch.utils.ServerResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
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
    private MailService mailService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("mail")
    public ServerResponse send(){
        SimpleMailMessage mail = mailService.createMail();

        rabbitTemplate.convertAndSend("emailExchange","email", mail);
        return ServerResponse.success();
    }
}
