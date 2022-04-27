package com.javaBasic.DesignPatterns.creational.builder;

/**
 * Created by JS
 * 建造者（Builder）模式在应用过程中可以根据需要改变，如果创建的产品种类只有一种，只需要一个具体建造者，
 * 这时可以省略掉抽象建造者，甚至可以省略掉指挥者角色。
 */
public class Test {
    public static void main(String[] args) {
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);

        Course course = coach.makeCourse("Java设计模式精讲",
                "Java设计模式精讲PPT",
                "Java设计模式精讲视频",
                "Java设计模式精讲手记",
                "Java设计模式精讲问答");
        System.out.println(course);

    }
}
