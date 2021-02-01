package cn.ch.controller;

import cn.ch.pojo.JujkLsJksqb;
import cn.ch.pojo.Message;
import cn.ch.utils.JsonUtils;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

    @GetMapping("/sendDirectMessageTest")
    public String sendDirectMessageTest(){
        JujkLsJksqb jujkLsJksqb = new JujkLsJksqb();
        jujkLsJksqb.setId("1346994727022612481");
        jujkLsJksqb.setOrgncode("C1031633000025");
        jujkLsJksqb.setVisitip("60.25.1.38");
        jujkLsJksqb.setJkid("100001");
        jujkLsJksqb.setSm2my("338ced320fc3c27cd64ef83441ee8806e1a122e9f300ef22da2240070fb42817");
        jujkLsJksqb.setQysj(new Date());
        jujkLsJksqb.setTzsj(new Date());
        jujkLsJksqb.setQtzt("1");
        jujkLsJksqb.setRkrq(null);
        jujkLsJksqb.setXgrq(null);
        jujkLsJksqb.setUserid("15555555555");
        jujkLsJksqb.setActualip(null);
        jujkLsJksqb.setMac(null);
        jujkLsJksqb.setSm4my("BEFF104E25754A958F");
        jujkLsJksqb.setSm4gxrq(new Date());
        jujkLsJksqb.setSm2gy("04211c988ac4e4c5884f84d8dff190b607f99231d4c8284f06d5bf7809a07f7278b24a61a93de22d5b930fcaa3ee953ac4e70ef01f763e0a946654567bef485dd5");
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("TestDirectExchange","direct", JsonUtils.objectToJson(jujkLsJksqb),correlationData);
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
