package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 10:43 2018/5/28
 * @Modified By:
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null )
            return sortList(l2,null);
        else if (l2==null)
            return sortList(l1,null);
        else {
            return sortList(l1,l2);
        }
    }

    public ListNode sortList(ListNode l1,ListNode l2){
        if (l1==null) return null;
        else if (l2==null) return l1;
        List<Integer> list1 = new LinkedList();
        ListNode l = l1;
        list1.add(l1.val);
        ListNode tmp = l1;
        while (tmp.next!=null){
            tmp = tmp.next;
            list1.add(tmp.val);
        }
        tmp.next = l2;
        int len1 = list1.size();
        ListNode tmp2 = l2;
        list1.add(l2.val);
        while (tmp2.next!=null){
            tmp2 = tmp2.next;
            list1.add(tmp2.val);
        }
        Collections.sort(list1);

        l.val=list1.get(0);
        int i=1;
        ListNode tmp3 = l;
        while (tmp3.next!=null){
            tmp3 = tmp3.next;
            tmp3.val = list1.get(i);
            i++;
        }
        return l;

    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}


