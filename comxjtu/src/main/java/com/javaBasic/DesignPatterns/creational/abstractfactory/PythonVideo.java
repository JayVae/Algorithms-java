package com.javaBasic.DesignPatterns.creational.abstractfactory;

/**
 * Created by js
 */
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Python课程视频");
    }
}
