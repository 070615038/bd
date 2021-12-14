package com.springcloudeureka.produces1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Produces1Application {

    public static void main(String[] args) {
        SpringApplication.run(Produces1Application.class, args);
    }

}
