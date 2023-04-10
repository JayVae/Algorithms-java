package com.leetcode.everyday;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/10 11:36
 * @description //1019. 链表中的下一个更大节点
 */
public class NextLargerNodes {

    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            List<Integer> ans = new ArrayList<Integer>();
            Deque<int[]> stack = new ArrayDeque<int[]>();

            ListNode cur = head;
            int idx = -1;
            while (cur != null) {
                ++idx;
                ans.add(0);
                while (!stack.isEmpty() && stack.peek()[0] < cur.val) {
                    ans.set(stack.pop()[1], cur.val);
                }
                stack.push(new int[]{cur.val, idx});
                cur = cur.next;
            }

            int size = ans.size();
            int[] arr = new int[size];
            for (int i = 0; i < size; ++i) {
                arr[i] = ans.get(i);
            }
            return arr;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
}
