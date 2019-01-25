package com.java.concurrent;

/**
 * @Author: Jay
 * @Date: Created in 14:44 2018/8/7
 * @Modified By:
 */
public class ThreadCommunication {

    public static void main(String[] args){
        final Object lock = new Object();

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("A 1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("A 2");
                    System.out.println("A 3");
                }

            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");

                    lock.notify();
                }
            }
        });

        A.start();
        B.start();
    }
}
