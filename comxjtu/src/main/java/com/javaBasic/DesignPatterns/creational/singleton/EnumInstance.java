package com.javaBasic.DesignPatterns.creational.singleton;

/**
 * Created by js
 */
public enum EnumInstance {
    INSTANCE{
        protected  void printTest(){
            System.out.println("js Print Test");
        }
    };
    protected abstract void printTest();
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static EnumInstance getInstance(){
        return INSTANCE;
    }

}
