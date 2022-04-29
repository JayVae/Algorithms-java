package com.javaBasic.DesignPatterns.creational.prototype.abstractprototype;

/**
 * Created by js
 */
public abstract class A implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
