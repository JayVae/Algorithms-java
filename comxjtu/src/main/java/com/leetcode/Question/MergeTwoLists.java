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
        if (l1==null)
            return sortList(l2,null);
        else if (l2==null)
            return sortList(l1,null);
        else {
            return sortList(l1,l2);
        }
    }

    public ListNode sortList(ListNode l1,ListNode l2){
        if (l1==null) return null;
        List<Integer> list1 = new LinkedList();
        ListNode l = l1;
        list1.add(l1.val);
//        用于每次推进
        ListNode tmp =
        while (l1.next!=null){
            l1 = l1.next;
            list1.add(l1.val);
        }
        int len1 = list1.size();
        l1.next=l2;
        list1.add(l2.val);
        while (l2.next!=null){
            l2 = l2.next;
            list1.add(l2.val);
        }
        Collections.sort(list1);
        l.val=list1.get(0);
        int i=1;
        while (l.next!=null){
            l = l.next;
            l.val = list1.get(i);
            i++;
        }
        while (l)
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


