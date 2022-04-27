package com.javaBasic.DesignPatterns.creational.abstractfactory;

/**
 * Created by geely
 */
public class PythonCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}
