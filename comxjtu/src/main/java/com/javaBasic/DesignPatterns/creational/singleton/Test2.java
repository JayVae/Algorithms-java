package com.javaBasic.DesignPatterns.creational.singleton;

public class Test2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());

        t1.start();
        t2.start();

        System.out.println("end");
    }
}
