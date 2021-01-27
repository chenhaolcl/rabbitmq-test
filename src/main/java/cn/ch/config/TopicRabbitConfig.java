package cn.ch.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname TopicRabbitConfig
 * @Description
 * @create 2021/1/25
 * @Author random
 */
@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue topicQueueOne(){
        return new Queue("TestTopicQueue.one",true);
    }

    @Bean
    public Queue topicQueueTwo(){
        return new Queue("TestTopicQueue.two",true);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("TestTopicExchange",true,false);
    }

    @Bean
    public Binding bindingTopicOne(){
        return BindingBuilder.bind(topicQueueOne()).to(topicExchange()).with("topic.#");
    }

    @Bean
    public Binding bindingTopicTwo(){
        return BindingBuilder.bind(topicQueueTwo()).to(topicExchange()).with("topic.*");
    }

}
