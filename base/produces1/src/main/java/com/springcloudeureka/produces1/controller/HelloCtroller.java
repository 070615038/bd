package com.springcloudeureka.produces1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class HelloCtroller {
    @RequestMapping("/hello")
    public String hello() throws InterruptedException {
        Thread.sleep(1000*10);
        return "hellowolrd 1"+Thread.currentThread().getName();
    }
    @RequestMapping("/hello1")
    public String hello1() throws InterruptedException {
        Thread.sleep(1000*10);
        return "hellowolrd 1"+Thread.currentThread().getName();
    }
}
