package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 9:22 2018/7/14
 * @Modified By:
 */
public class lc25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode d = new ListNode(0);
        ListNode ret = d;
        d.next = head;
        helper(d,k);
        return ret.next;
    }

    private ListNode helper(ListNode d, int k){
        if(k<=1) return d;
        int t = k;
        ListNode p = d;
        while(p.next!=null){
            p = p.next;
            if(--t==0) break;
        }
        if(t==0){
            ListNode[] list = new ListNode[k];
            ListNode tmp = d;
            for(int i = 0 ; i < k ; i++){
                tmp = tmp.next;
                list[i] = tmp;
            }
            tmp = d;
            tmp.next = list[k-1];
            list[0].next = list[k-1].next;
            for(int i = 1 ; i < k ; i++){
                list[i].next = list[i-1];
            }
            tmp = list[0];
            helper(tmp,k);
        }
        return d;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
