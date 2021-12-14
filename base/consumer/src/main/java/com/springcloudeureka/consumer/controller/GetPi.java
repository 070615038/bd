package com.springcloudeureka.consumer.controller;

public class GetPi {
    public static void main(String[] args) {
        int loopCount = 99999999;
        int piCount = 0;
        for(int i = 0; i < loopCount; i++) {
            double x = Math.random();
            double y = Math.random();
            if( (x*x+y*y)<=1.0        ) {
                piCount++;
            }
        }
        System.out.println("圆周率估算值=" + (   (float)(4*piCount/(loopCount) )     ));
    }
}
