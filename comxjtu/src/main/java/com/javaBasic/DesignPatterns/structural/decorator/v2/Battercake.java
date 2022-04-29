package com.javaBasic.DesignPatterns.structural.decorator.v2;

/**
 * Created by js
 */
public class Battercake extends ABattercake {
    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
