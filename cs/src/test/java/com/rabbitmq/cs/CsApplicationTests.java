package com.rabbitmq.cs;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CsApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() {
    }
    @Test
    void test(){
        System.out.println("11111111");
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setConfirmCallback( new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                System.out.println(b);
                if(b){

                }else {

                }
            }
        });
        Queue queue = new Queue("test",true);
        Exchange topicExchange = new TopicExchange("test");

        Binding binding = BindingBuilder.bind(queue).to(topicExchange).with("*.boot").noargs();
        //rabbitTemplate.convertAndSend("test","b.boot", "44444");
        rabbitTemplate.convertAndSend("test_exchange2","boot", "22222");
        rabbitTemplate.convertAndSend("queue1","22222");
    }

   /* @Test
    @RabbitListener(queues="queue1")
    void test1(Message ms){
        System.out.println("消费消息了。。。。。");
        System.out.println(ms.getBody());

    }*/

  /* public static void main(String[] args) throws Exception{

        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/zyd");
        connectionFactory.setPassword("guest");
        connectionFactory.setUsername("guest");
        Connection connection = (Connection) connectionFactory.newConnection();
       Channel channel = connection.createChannel();
       channel.queueDeclare("queue",true,false,false,null);
       channel.basicPublish("","queue",null,"cs111".getBytes());
       channel.close();
       connection.close();
    }*/

}
