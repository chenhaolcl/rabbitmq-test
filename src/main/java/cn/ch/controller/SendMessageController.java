package cn.ch.controller;

import cn.ch.pojo.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @Classname SendMessageController
 * @Description
 * @create 2021/1/25
 * @Author random
 */
@RestController
public class SendMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage(){
        Message message = new Message();
        message.setMessageId(String.valueOf(UUID.randomUUID()));
        message.setMessageData("hello direct test");
        message.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("TestDirectExchange","direct",message,correlationData);
        return "ok";
    }

    @GetMapping("/sendTopicMessageOne")
    public String sendTopicMessageOne(){
        Message message = new Message();
        message.setMessageId(String.valueOf(UUID.randomUUID()));
        message.setMessageData("hello topic test");
        message.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        rabbitTemplate.convertAndSend("TestTopicExchange","topic.abc",message);
        return "ok";
    }

    @GetMapping("/sendTopicMessageTwo")
    public String sendTopicMessageTwo(){
        Message message = new Message();
        message.setMessageId(String.valueOf(UUID.randomUUID()));
        message.setMessageData("hello topic test");
        message.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        rabbitTemplate.convertAndSend("TestTopicExchange","topic.abc.aaa",message);
        return "ok";
    }

    @GetMapping("/sendFanoutMessage")
    public String sendFanoutMessage(){
        Message message = new Message();
        message.setMessageId(String.valueOf(UUID.randomUUID()));
        message.setMessageData("hello fanout test");
        message.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        rabbitTemplate.convertAndSend("TestFanoutExchange",null,message);
        return "ok";
    }

    @GetMapping("/sendErrorMessage")
    public String sendErrorMessage(){
        Message message = new Message();
        message.setMessageId(String.valueOf(UUID.randomUUID()));
        message.setMessageData("hello fanout test");
        message.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        rabbitTemplate.convertAndSend("Exchange",null,message);
        return "ok";
    }
}
