package com.javaBasic.DesignPatterns.creational.factorymethod;

/**
 * Created by js
 */
public class FEVideo extends Video{
    @Override
    public void produce() {
        System.out.println("录制FE课程视频");
    }
}
