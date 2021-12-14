package com.springcloudeureka.consumer.controller;

import com.google.inject.internal.cglib.core.$ReflectUtils;
import com.netflix.discovery.DiscoveryClient;
import com.springcloudeureka.consumer.serverice.helloservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@ResponseBody
public class HelloController {
    @Autowired
    RestTemplate rest;
    @Autowired
    helloservice s;
    @RequestMapping("/hello")
    public String helloWolrd(){
        for(int i =0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String result = rest.getForObject("http://PRODUCES/hello",String.class);
                    System.out.println(result);
                }
            }).start();
        }
        String result = rest.getForObject("http://PRODUCES/hello",String.class);
        return result ;

    }
    @RequestMapping("/hello1")
    public String helloWolrd1(){
        String result = s.getHello();
        return result ;

    }

}
