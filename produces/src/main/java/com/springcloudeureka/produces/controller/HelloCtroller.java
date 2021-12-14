package com.springcloudeureka.produces.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class HelloCtroller {
    @RequestMapping("/hello")
    public String hello(){
        return "hellowolrd 1";
    }
    @RequestMapping("/hello1")
    public String hello1(){
        return "hellowolrd 1";
    }
}
