package cn.ch.Listener;

import cn.ch.pojo.Message;
import cn.ch.utils.JsonUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname FanoutReceiverOne
 * @Description
 * @create 2021/1/25
 * @Author random
 */
@Component
@RabbitListener(queues = "TestFanoutThree")
public class FanoutReceiverThree {

    @RabbitHandler
    public void process(Message message){
        System.out.println("FanoutReceiverThree收到消息：" + JsonUtils.objectToJson(message));
}
}
