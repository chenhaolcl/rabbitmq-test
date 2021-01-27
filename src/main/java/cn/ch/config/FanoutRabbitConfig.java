package cn.ch.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname FanoutRabbitConfig
 * @Description
 * @create 2021/1/25
 * @Author random
 */
@Configuration
public class FanoutRabbitConfig {

    @Bean
    public Queue testFanoutOne(){
        return new Queue("TestFanoutOne",true);
    }
    @Bean
    public Queue testFanoutTwo(){
        return new Queue("TestFanoutTwo",true);
    }
    @Bean
    public Queue testFanoutThree(){
        return new Queue("TestFanoutThree",true);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("TestFanoutExchange",true,false);
    }

    @Bean
    public Binding bindingOne(){
        return BindingBuilder.bind(testFanoutOne()).to(fanoutExchange());
    }
    @Bean
    public Binding bindingTwo(){
        return BindingBuilder.bind(testFanoutTwo()).to(fanoutExchange());
    }
    @Bean
    public Binding bindingThree(){
        return BindingBuilder.bind(testFanoutThree()).to(fanoutExchange());
    }

}
