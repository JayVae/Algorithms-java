package com.javaBasic.DesignPatterns.structural.adapter.classadapter;

/**
 * Created by js
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }

}
