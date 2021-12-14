package com.springcloudeureka.consumer.serverice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@FeignClient(name = "http://produces")
public interface helloservice {
    @ResponseBody
    @RequestMapping("hello1")
    public String getHello();
}
