package cn.ch.Listener;

import cn.ch.pojo.entity.JujkLsJksqb;
import cn.ch.utils.JsonUtils;
import cn.ch.utils.JsonUtilss;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @Classname DirectReceiver
 * @Description
 * @create 2021/1/25
 * @Author random
 */
@Component
public class DirectReceiver {

    @Autowired
    private JavaMailSender sender;

//    @RabbitListener(
//            bindings = @QueueBinding(
//                    value = @Queue(value = "TestDirectQueue", durable = "true"),
//                    exchange = @Exchange(
//                            value = "TestDirectExchange",
//                            ignoreDeclarationExceptions = "true",
//                            type = ExchangeTypes.DIRECT),
//                    key = {"direct"}))
//    public void process(cn.ch.pojo.Message message, Channel channel, org.springframework.amqp.core.Message m) throws Exception{
//        System.out.println("第一个DirectReceiver消费者收到消息  : "+JsonUtils.objectToJson(message));
//        System.out.println(m.getMessageProperties().getDeliveryTag());
//        channel.basicAck(m.getMessageProperties().getDeliveryTag(),false);
//    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "TestDirectQueue", durable = "true"),
                    exchange = @Exchange(
                            value = "TestDirectExchange",
                            ignoreDeclarationExceptions = "true",
                            type = ExchangeTypes.DIRECT),
                    key = {"direct"}))
    public void process(String object, Channel channel, @Headers Map<String, Object> headers){
        JsonUtilss.jsonStr2Obj(object,JujkLsJksqb.class);
        try {
            channel.basicAck((Long)headers.get(AmqpHeaders.DELIVERY_TAG),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "emailQueue", durable = "true"),
                    exchange = @Exchange(
                            value = "emailExchange",
                            ignoreDeclarationExceptions = "true",
                            type = ExchangeTypes.DIRECT),
                    key = {"email"}))
    public void processEmail(SimpleMailMessage object, Channel channel, Message m){

        sender.send(object);
        try {
            channel.basicAck(m.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
