package com.rabbit.demo;




import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    @Bean(name="queue")
    public Queue getQueue(){

        return  QueueBuilder.durable("test_queue").maxLength(20).build();
    }
    @Bean(name="queue1")
    public Queue getQueue1(){

        return  QueueBuilder.durable("queue1").maxLength(20).build();
    }
    @Bean(name="exchange1")
    public FanoutExchange getExchange(){

        return ExchangeBuilder.fanoutExchange("test_exchange1").durable(true).build();

    }
    @Bean
    public Binding getBind(){

        return BindingBuilder.bind(getQueue()).to(getExchange());
    }


}
