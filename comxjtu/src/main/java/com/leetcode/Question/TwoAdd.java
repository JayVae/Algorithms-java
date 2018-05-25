package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 10:57 2018/5/25
 * @Modified By:
 */

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 下述的方法受到输入long的限制
 */
public class TwoAdd {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;
        long i1 = size(l1);
        long i2 = size(l2);
        if (i1==0 && i2==0){
            return l1;
        }else if (i1==0){
            return l2;
        }else if (i2==0){
            return l1;
        }
        long res = i1+i2;
//        System.out.println("i1_"+i1);
        System.out.println(i2);
//        System.out.println("result"+res);
        return trans(res);
    }

    public long size(ListNode l){
        int len=1;
        long dec = l.val;
        ListNode t = l;
        while (t.next!=null){
            len++;
            t=t.next;
            dec = dec+(long)t.val*(long) Math.pow(10,len-1);
//            System.out.println(dec);
        }
        return dec;
    }
    public ListNode trans(long k){
        ListNode ans = new ListNode((int) (k%10));
//        System.out.print(k%10);
        ListNode last = ans;
        k = k/10;
        while (k!=0){
            ListNode oldlast = last;
            last = new ListNode((int) (k%10));
//            System.out.print(" "+k%10);
            oldlast.next=last;
            k = k/10;
        }
//        System.out.println();
        return ans;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val=x;}
    }

}
