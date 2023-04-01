package com.javaBasic.DesignPatterns.creational.singleton;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author JS
 * @version 1.0
 * @date 2023/3/31 11:15
 * @description //TODO
 */
public class TicketTest {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 3; i++) {

            new Thread(() -> {
                try {
                    Thread.sleep((long)(Math.random() * 2000));
                    int randomInt = new Random().nextInt(500);
                    System.out.println("准备 " + randomInt);

                    cyclicBarrier.await();
                    while (true) {
                        Tickets tickets = Tickets.createTickets();
                        if (tickets == null) {
                            System.out.println("对不起，门票已经卖完");
                            break;
                        }
                    }
                    System.out.println("结束 " + randomInt);
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

    }

}
