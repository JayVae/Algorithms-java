package com.javaBasic.DesignPatterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author JS
 * @version 1.0
 * @date 2023/3/31 9:00
 * @description //练习写作singleton
 */
public class Singleton2 {
    private static volatile Singleton2 singleton = null;
    private static boolean flag=false;      // 定义一个静态类型的flag变量
    private Singleton2() {
        synchronized (Singleton2.class){
            if (!flag){          // 判断对象是否创建过
                flag=true;
            }else {
                throw new RuntimeException("请别用反射破坏单例模式");
            }
        }
//        if(singleton != null){
//            throw new RuntimeException("单例构造器禁止反射调用");
//        }
    }

    public static Singleton2 getInstance(){
        if (singleton == null) {
            synchronized (Singleton2.class){
                if (singleton == null) {
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor<? extends Singleton2> constructor = Singleton2.class.getDeclaredConstructor();

        Singleton2 instance3 = constructor.newInstance();
        Singleton2 instance4 = Singleton2.class.newInstance();
        constructor.setAccessible(true);        // 无视私有构造器
        Singleton2 instance2 = constructor.newInstance();
        Singleton2 instance5 = new Singleton2();
        Singleton2 instance1 = Singleton2.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
