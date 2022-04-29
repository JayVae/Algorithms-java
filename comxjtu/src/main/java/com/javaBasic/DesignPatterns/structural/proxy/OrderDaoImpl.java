package com.javaBasic.DesignPatterns.structural.proxy;

/**
 * Created by js
 */
public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        System.out.println("Dao层添加Order成功");
        return 1;
    }
}
