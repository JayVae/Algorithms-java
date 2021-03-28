package com.javaBasic.other;

import java.util.LinkedHashMap;

/**
 * @Author: Jay
 * @Date: Created in 10:02 2018/8/8
 * @Modified By:
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(20, 0.75f, true);
        for (int i = 0; i < 10; i++) {//按顺序放入1~9
            map.put(i, i);
        }
        System.out.println("原数据："+map.toString());
        map.get(3);
        System.out.println("查询存在的某一个："+map.toString());
        map.put(4, 4);
        System.out.println("插入已存在的某一个："+map.toString()); //直接调用已存在的toString方法，不然自己需要用迭代器实现
        map.put(10, 10);
        System.out.println("插入一个原本没存在的："+map.toString());

    }
}
