package com.javaBasic.DesignPatterns.creational.abstractfactory;

/**
 * Created by js
 */
public class JavaArticle extends Article {
    @Override
    public void produce() {
        System.out.println("编写Java课程手记");
    }
}
