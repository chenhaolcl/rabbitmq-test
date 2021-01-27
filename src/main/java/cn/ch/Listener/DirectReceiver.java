package cn.ch.Listener;


import cn.ch.pojo.Message;
import cn.ch.utils.JsonUtils;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname DirectReceiver
 * @Description
 * @create 2021/1/25
 * @Author random
 */
@Component
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver {

    @RabbitHandler
    public void process(Message message, Channel channel, org.springframework.amqp.core.Message m) throws Exception{
        System.out.println("第一个DirectReceiver消费者收到消息  : "+JsonUtils.objectToJson(message));
        channel.basicAck(m.getMessageProperties().getDeliveryTag(),false);
        channel.basicNack(m.getMessageProperties().getDeliveryTag(),false,false);
        channel.basicReject(m.getMessageProperties().getDeliveryTag(),false);
    }

}
