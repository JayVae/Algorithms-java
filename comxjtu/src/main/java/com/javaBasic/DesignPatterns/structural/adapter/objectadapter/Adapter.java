package com.javaBasic.DesignPatterns.structural.adapter.objectadapter;

/**
 * Created by geely
 */
public class Adapter implements Target{
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        //...
        adaptee.adapteeRequest();
        //...
    }
}
