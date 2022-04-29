package com.javaBasic.DesignPatterns.structural.proxy.dynamicproxy;


import com.javaBasic.DesignPatterns.structural.proxy.IOrderService;
import com.javaBasic.DesignPatterns.structural.proxy.Order;
import com.javaBasic.DesignPatterns.structural.proxy.OrderServiceImpl;

/**
 * Created by js
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
//        order.setUserId(2);
        order.setUserId(1);
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();

        orderServiceDynamicProxy.saveOrder(order);
    }
}
