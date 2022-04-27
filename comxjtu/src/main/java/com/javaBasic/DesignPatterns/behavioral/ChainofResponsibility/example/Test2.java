package com.javaBasic.DesignPatterns.behavioral.ChainofResponsibility.example;

/**
 * 【例1】用责任链模式设计一个请假条审批模块。

 分析：假如规定学生请假小于或等于 2 天，班主任可以批准；小于或等于 7 天，系主任可以批准；小于或等于 10 天，
 院长可以批准；其他情况不予批准；这个实例适合使用职责链模式实现。
 */
public class Test2 {

    public static void main(String[] args) {
        //组装责任链
        Leader teacher1 = new ClassAdviser();
        Leader teacher2 = new DepartmentHead();
        Leader teacher3 = new Dean();
        Leader teacher4=new DeanOfStudies();
        teacher1.setNext(teacher2);
        teacher2.setNext(teacher3);
        //teacher3.setNext(teacher4);
        //提交请求
        teacher1.handleRequest(8);
    }
}
