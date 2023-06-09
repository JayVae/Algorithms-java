package com.javaBasic.DesignPatterns.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by js
 */
public class LazySingleton implements Cloneable{
    private static LazySingleton lazySingleton = null;
    private LazySingleton(){
        if(lazySingleton != null){
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }
    public synchronized static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, CloneNotSupportedException {
        Class objectClass = LazySingleton.class;
        Constructor c = objectClass.getDeclaredConstructor();
        c.setAccessible(true);

        System.out.println(c);
        LazySingleton o2 = (LazySingleton) c.newInstance();
        LazySingleton o3 = new LazySingleton();
        LazySingleton o1 = LazySingleton.getInstance();

        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o1==o2);
        System.out.println(o3);

        LazySingleton o4 = (LazySingleton) o1.clone();
        System.out.println(o4);
    }

}
