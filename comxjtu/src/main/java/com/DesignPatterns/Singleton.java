package com.DesignPatterns;

/**
 * @Author: Jay
 * @Date: Created in 7:31 2018/8/30
 * @Modified By:
 */
public class Singleton {

        private static Singleton singleton = new Singleton();

        private Singleton(){
        }

        public static Singleton getInstance(){
            return singleton;
        }
}
