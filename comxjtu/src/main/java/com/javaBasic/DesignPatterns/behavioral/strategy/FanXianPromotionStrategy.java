package com.javaBasic.DesignPatterns.behavioral.strategy;

/**
 * Created by js
 */
public class FanXianPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("返现促销,返回的金额存放到慕课网用户的余额中");
    }
}
