package com.javaBasic.DesignPatterns.creational.factorymethod;

/**
 * Created by js
 */
public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
