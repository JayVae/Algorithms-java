package com.javaBasic.DesignPatterns.behavioral.iterator;

/**
 * Created by js.
 */
public interface CourseAggregate {

    void addCourse(Course course);
    void removeCourse(Course course);

    CourseIterator getCourseIterator();



}
