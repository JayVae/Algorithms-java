package com.javaBasic.DesignPatterns.structural.adapter.classadapter;

/**
 * Created by js
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        //...
        super.adapteeRequest();
        //...
    }
}
