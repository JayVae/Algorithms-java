package com.leetcode.middle;

/**
 * @Author: Jay
 * @Date: Created in 15:59 2018/6/13
 * @Modified By:
 */
public class Link {
    /**
     * 奇偶链表:
     * 第一种方法是有问题的，因为引用相等的，容易出错；
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode oddcurrent = head;
        ListNode evenfirst = head.next;
        ListNode evencurrent = evenfirst;
        ListNode oddlast = null;
        while (oddcurrent.next!=null||evencurrent.next!=null){
            if (oddcurrent.next.next!=null){
                evencurrent.next = evencurrent.next.next;
                oddcurrent.next = oddcurrent.next.next;
                oddcurrent = oddcurrent.next;
                evencurrent = evencurrent.next;
                System.out.println(oddcurrent.val+" "+oddcurrent.next);
                System.out.println(oddcurrent.next==null);
            }else {
                oddlast = oddcurrent;
                oddcurrent.next = null;
                break;
            }
        }
        if (oddlast==null){
            oddlast = oddcurrent;
        }
        oddlast.next = evenfirst.next;
        return head;
    }
    public ListNode oddEvenList2(ListNode head) {
        if (head != null) {

            ListNode odd = head, even = head.next, evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
}
