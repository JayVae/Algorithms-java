package com.javaBasic.DesignPatterns.creational.singleton;

import java.util.Date;

/**
 * @author JS
 * @version 1.0
 * @date 2023/3/31 11:14
 * @description //要求：创建一个门票类，开启3个线程进行售卖，总共只有500张票。
 * 这里采用DCL懒汉式实现。
 */
public class Tickets {
    private static int count = 0;	// 以售卖票数
    private final static int num = 500;		// 门票数目
    private Date time;
    private Double price;

    private Tickets() {
        count++;
    }

    private Tickets(Date time, Double price) {
        this.time = time;
        this.price = price;
        count++;
    }

    // 无参
    public static Tickets createTickets(){
        if (count<num){
            synchronized (Tickets.class){
                if (count<num){
                    String name = Thread.currentThread().getName();
                    System.out.println("当前线程："+name+"------正在卖出第"+(count+1)+"张票");
                    return new Tickets();
                }else {
                    return null;
                }
            }
        }
        return null;
    }

    // 有参
    public static Tickets createTickets(Date time, Double price){
        if (count<num){
            synchronized (Tickets.class){
                if (count<num){
                    System.out.println("正在卖出第"+(count+1)+"张票");
                    return new Tickets(time,price);
                }else {
                    return null;
                }
            }
        }
        return null;
    }

    // set/get方法
}
