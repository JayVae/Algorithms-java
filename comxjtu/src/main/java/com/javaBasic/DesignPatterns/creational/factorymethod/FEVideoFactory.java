package com.javaBasic.DesignPatterns.creational.factorymethod;

/**
 * Created by js
 */
public class FEVideoFactory extends VideoFactory{
    @Override
    public Video getVideo() {
        return new FEVideo();
    }
}
