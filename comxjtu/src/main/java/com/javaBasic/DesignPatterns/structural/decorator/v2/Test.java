package com.javaBasic.DesignPatterns.structural.decorator.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        ABattercake aBattercake;
        aBattercake = new Battercake();
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new SausageDecorator(aBattercake);

        System.out.println(aBattercake.getDesc()+" 销售价格:"+aBattercake.cost());

        InputStreamReader isr = new InputStreamReader(System.in); // 读取
        // 创建字符流缓冲区
        BufferedReader br = new BufferedReader(isr); // 缓冲
        // 读取一个文本行
        try {
            String s = br.readLine(); // 阻塞式，当没有数据读取时，就一直会阻塞，而不是返回null
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
