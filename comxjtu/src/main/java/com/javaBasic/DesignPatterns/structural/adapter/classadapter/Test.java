package com.javaBasic.DesignPatterns.structural.adapter.classadapter;

/**
 * Created by js
 */
public class Test {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();



    }
}
