package com.javaBasic.DesignPatterns.creational.abstractfactory;

/**
 * Created by js
 */
public class PythonArticle extends Article {
    @Override
    public void produce() {
        System.out.println("编写Python课程手记");
    }
}
