package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 9:28 2018/7/14
 * @Modified By:
 */
public class lc24 {

    public ListNode swapPairs(ListNode head) {
        if (head==null) return null;

        ListNode dummynode = new ListNode(0);
        dummynode.next = head;
        ListNode cur = dummynode;

        while (!(cur==null || cur.next==null || cur.next.next==null)){
            ListNode n1 = cur.next;
            ListNode n2 = cur.next.next;

            cur.next = n2;
            n1.next = n2.next;
            n2.next = n1;

            cur=n1;
        }

        return dummynode.next;
    }
}
