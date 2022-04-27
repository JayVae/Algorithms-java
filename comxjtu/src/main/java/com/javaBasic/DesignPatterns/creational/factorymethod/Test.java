package com.javaBasic.DesignPatterns.creational.factorymethod;

/**
 * Created by JS
 * 在实际过程中，并不是通过显式的new具体的工厂类，而是通过读配置文件等方式生成。例如通过Test中的方式
 * 工厂方法模式的主要角色如下。
 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 newProduct() 来创建产品。
 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
 */
public class Test {
    public static void main(String[] args) {
//        VideoFactory videoFactory = new PythonVideoFactory();
//        VideoFactory videoFactory2 = new JavaVideoFactory();
//        VideoFactory videoFactory3 = new FEVideoFactory();
        VideoFactory videoFactory = (VideoFactory)ReadXML1.getObject();
        Video video = videoFactory.getVideo();
        video.produce();

    }

}
