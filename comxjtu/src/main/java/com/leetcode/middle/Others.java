package com.leetcode.middle;

import java.util.*;

/**
 * @Author: Jay
 * @Date: Created in 14:05 2018/6/22
 * @Modified By:
 */
public class Others {
    /**
     * 两整数之和：不使用运算符 + 和-，计算两整数a 、b之和。
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        int res = 0;
        //不进位的加和
        int xor = a^b;

        //进位和
        int forward = (a&b)<<1;
        if(forward != 0){
            res = getSum(xor,forward);//循环处理 进位和+不进位加和
        }else {
            res = xor;
        }
        return res;
    }

    /**
     * 逆波兰表达式求值
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String s :
                tokens) {
            int a,b;
            switch (s){
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a+b);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b-a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b*a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b/a);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    /**
     * 求众数：给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * Task Scheduler
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks==null || tasks.length==0) return 0;
        if (n==0) return tasks.length;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        int t = map.size();
        int ans=0;
        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        int last = 0;
        for(Map.Entry<Character,Integer> mapping:list){
            if (!map.containsKey(mapping.getKey())) continue;
            int tmp = map.get(mapping.getKey());
            if (t-1<n){
                ans = ans + (n+1)*tmp;
            }else {
                ans = ans + t*tmp;
            }
            map.remove(mapping.getKey());
            last=t;
            Map<Character,Integer> map2 = new HashMap<>();
            map2.putAll(map);
            for(Character key:map2.keySet()){
                if ((map.get(key)-tmp)==0){
                    map.remove(key);
                }else {
                    map.put(key,map.get(key)-tmp);
                }
            }
            t--;
        }
        return ans-(n+1)+last;
    }

    public static void main(String[] args){
        Others others = new Others();
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        System.out.println(others.leastInterval(tasks, 2));
    }
}
