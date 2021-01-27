package cn.ch.Listener;

import cn.ch.pojo.Message;
import cn.ch.utils.JsonUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname TopicReceiverOne
 * @Description
 * @create 2021/1/25
 * @Author random
 */
@Component
@RabbitListener(queues = "TestTopicQueue.one")
public class TopicReceiverOne {

    @RabbitHandler
    public void process(Message message){
        System.out.println("TopicReceiverOne收到消息：" + JsonUtils.objectToJson(message));
    }

}
