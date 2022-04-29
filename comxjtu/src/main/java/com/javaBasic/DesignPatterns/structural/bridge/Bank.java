package com.javaBasic.DesignPatterns.structural.bridge;

/**
 * Created by js
 */
public abstract class Bank {
    protected Account account;
    public Bank(Account account){
        this.account = account;
    }
    abstract Account openAccount();

}
