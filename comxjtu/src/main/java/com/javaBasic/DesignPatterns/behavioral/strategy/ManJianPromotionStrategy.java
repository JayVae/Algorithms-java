package com.javaBasic.DesignPatterns.behavioral.strategy;

/**
 * Created by geely
 */
public class ManJianPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("满减促销,满200-20元");
    }
}
