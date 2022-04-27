package com.javaBasic.DesignPatterns.behavioral.Mediator;

abstract class Mediator {
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague cl); //转发
}
