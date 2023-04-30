package com.leetcode.design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/28 21:11
 * @description //1172 餐盘栈
 */
class DinnerPlates {
    int capacity;
    List<Integer> stack;
    List<Integer> top;
    TreeSet<Integer> poppedPos;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stack = new LinkedList<>();
        top = new ArrayList<>();
        poppedPos = new TreeSet<>();
    }

    public void push(int val) {
        if (poppedPos.isEmpty()) {
            int pos = stack.size();
            stack.add(val);
            if (pos % capacity == 0) {
                top.add(0);
            }
            else {
                int stackPos = top.size()-1;
                int stackTop = top.get(stackPos);
                top.set(stackPos, stackTop + 1);
            }
        } else {
            int pos = poppedPos.pollFirst();
            stack.set(pos, val);
            int index = pos / capacity;
            int stackTop = top.get(index);
            top.set(index, stackTop + 1);
        }
    }

    public int pop() {
        while (!stack.isEmpty() && poppedPos.contains(stack.size()-1)) {
            stack.remove(stack.size()-1);
            int pos = poppedPos.pollLast();
            if (pos % capacity == 0) {
                top.remove(top.size()-1);
            }
        }
        if (stack.isEmpty()) {
            return -1;
        } else {
            int pos = stack.size() - 1;
            int val = stack.get(pos);
            stack.remove(pos);
            int index = top.size()-1;
            if (pos % capacity == 0) {
                top.remove(index);
            } else {
                top.set(index, index - 1);
            }
            return val;
        }
    }

    public int popAtStack(int index) {
        if (index >= top.size()) {
            return -1;
        }
        int stackTop = top.get(index);
        if (stackTop < 0) {
            return -1;
        }
        top.set(index, stackTop - 1);
        int pos = index * capacity + stackTop;
        poppedPos.add(pos);
        return stack.get(pos);
    }
}
