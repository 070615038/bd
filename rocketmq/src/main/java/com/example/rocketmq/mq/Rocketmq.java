package com.example.rocketmq.mq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Component;

@Component
public class Rocketmq {
    public void producer()  {
        DefaultMQProducer producer =new DefaultMQProducer("group1");
        //设置nameserver
        producer.setNamesrvAddr("localhost:9876" );
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        Message msg = new Message("topic","tag","hello wold".getBytes());
        try {
           SendResult result= producer.send(msg);
            System.out.println(result.getMsgId());
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //producer.shutdown();

    }
}
