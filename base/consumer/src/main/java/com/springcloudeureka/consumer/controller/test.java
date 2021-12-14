package com.springcloudeureka.consumer.controller;

public class test {
    public static void main(String[] args) {
        A a =new A();
        B b =new B(a);
        b.say();
    }
}
interface c {
    void say();
}
class  A  implements  c{
    @Override
    public void say() {
        System.out.println(1111);
    }
}
class B implements  c{
    private c  x;

    public B(c x) {
        this.x = x;
    }

    @Override
    public void say() {
        System.out.println(22222);
        x.say();
        System.out.println(333333);
    }
}


