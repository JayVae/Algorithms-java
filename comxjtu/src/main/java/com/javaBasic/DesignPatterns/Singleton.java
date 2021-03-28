package com.javaBasic.DesignPatterns;

/**
 * @Author: Jay
 * @Date: Created in 7:31 2018/8/30
 * @Modified By:
 */

// 加同步锁时，前后两次判断实例是否存在
public class Singleton {
        private static Singleton instance=null;
        private Singleton(){

        }
        public static Singleton getInstance(){
                if(instance==null){
                        synchronized(Singleton.class){
                                if(instance==null){
                                        instance=new Singleton();
                                }
                        }
                }
                return instance;
        }
}
