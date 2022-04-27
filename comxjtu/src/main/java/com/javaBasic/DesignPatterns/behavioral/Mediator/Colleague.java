package com.javaBasic.DesignPatterns.behavioral.Mediator;

//抽象同事类
abstract class Colleague {
    protected Mediator mediator;
    public void setMedium(Mediator mediator) {
        this.mediator = mediator;
    }
    public abstract void receive();
    public abstract void send();
}
