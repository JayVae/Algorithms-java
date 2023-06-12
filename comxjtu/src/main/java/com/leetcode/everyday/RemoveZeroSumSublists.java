package com.leetcode.everyday;

import com.leetcode.util.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/12 10:44
 * @description //1171. 从链表中删去总和值为零的连续节点
 * 前缀和
 */
public class RemoveZeroSumSublists {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> seen = new HashMap<>();
        int prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            seen.put(prefix, node);
        }
        prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            node.next = seen.get(prefix).next;
        }
        return dummy.next;
    }
}
