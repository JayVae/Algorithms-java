package com.javaBasic.DesignPatterns.creational.factorymethod;

/**
 * Created by js
 */
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Java课程视频");
    }
}
