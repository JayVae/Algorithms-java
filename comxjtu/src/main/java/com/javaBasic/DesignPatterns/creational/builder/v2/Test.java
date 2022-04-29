package com.javaBasic.DesignPatterns.creational.builder.v2;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * Created by js
 */
public class Test {
    public static void main(String[] args) {
        Course course = new Course.CourseBuilder().buildCourseName("Java设计模式精讲").buildCoursePPT("Java设计模式精讲PPT").buildCourseVideo("Java设计模式精讲视频").build();
        System.out.println(course);

        Set<String> set = ImmutableSet.<String>builder().add("a").add("b").build();

        System.out.println(set);
    }
}
