package com.javaBasic.DesignPatterns.creational.singleton;

/**
 * Created by js
 */
public class LazySingletonUnsafe {
    private static LazySingletonUnsafe lazySingleton = null;
    private LazySingletonUnsafe(){
    }
    public static LazySingletonUnsafe getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingletonUnsafe();
        }
        return lazySingleton;
    }

//    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
//        Class objectClass = LazySingleton.class;
//        Constructor c = objectClass.getDeclaredConstructor();
//        c.setAccessible(true);
//
//        LazySingleton o1 = LazySingleton.getInstance();
//
//        Field flag = o1.getClass().getDeclaredField("flag");
//        flag.setAccessible(true);
//        flag.set(o1,true);
//
//
//        LazySingleton o2 = (LazySingleton) c.newInstance();
//
//        System.out.println(o1);
//        System.out.println(o2);
//        System.out.println(o1==o2);
//    }

}
