package com.javaBasic.DesignPatterns.structural.proxy.staticproxy;


import com.javaBasic.DesignPatterns.structural.proxy.Order;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }
}
