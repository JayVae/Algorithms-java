package com.leetcode.util;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/11 10:12
 * @description //TODO
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
