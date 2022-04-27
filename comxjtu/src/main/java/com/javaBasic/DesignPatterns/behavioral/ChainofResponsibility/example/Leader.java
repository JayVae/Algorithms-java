package com.javaBasic.DesignPatterns.behavioral.ChainofResponsibility.example;

abstract public class Leader {

    private Leader next;
    public void setNext(Leader next) {
        this.next = next;
    }
    public Leader getNext() {
        return next;
    }
    //处理请求的方法
    public abstract void handleRequest(int LeaveDays);
}
