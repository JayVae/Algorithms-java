package com.javaBasic.DesignPatterns.creational.factorymethod;

/**
 * Created by js
 */
public class PythonVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
