package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 8:57 2018/7/14
 * @Modified By:
 */
public class lc203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return null;

        ListNode dummynode = new ListNode(0);
        dummynode.next = head;
        ListNode cur = dummynode;
        while (cur.next!=null){
            if(cur.next.val==val){
                ListNode del = cur.next;
                cur.next = del.next;
                del.next = null;
            }else {
                cur = cur.next;
            }
            if (cur==null)
                break;
        }
        return dummynode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
