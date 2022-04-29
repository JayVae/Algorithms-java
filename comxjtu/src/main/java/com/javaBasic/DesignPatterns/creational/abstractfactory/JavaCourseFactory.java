package com.javaBasic.DesignPatterns.creational.abstractfactory;

/**
 * Created by js
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
