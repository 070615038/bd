package com.example.rocketmq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RocketmqApplicationTests {

    @Test
    void contextLoads() {
        String st = SpringBootVersion.getVersion();
        System.out.println(st);
    }

}
