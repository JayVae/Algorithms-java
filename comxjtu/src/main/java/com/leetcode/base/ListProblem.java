package com.leetcode.base;

import com.leetcode.middle.Link;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/2 15:53
 * @description //leetcode链表专题：https://leetcode.cn/leetbook/read/linked-list/
 */
public class ListProblem {


    /**
     *
     * @Description //环形链表II  给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * @Date 15:55 2022/5/2
     * @return
     **/
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        //快慢指针相遇
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //第一次相遇退出循环
            if (slow == fast) break;
        }
        //判断是否有环
        if(fast==null||fast.next==null)return null;
        //有环则将fast移动至head并移动S2距离
        fast=head;
        while(fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }

    /**
     *
     * @Description //相交链表：双指针.
     * 我这种方法算是比较复杂的了，看题解有的直接将两个链表首位续起来，成为两个新的链表，即A+B和B+A,然后同时向后走就行。
     * @Date 16:19 2022/5/2
     * @return
     **/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null|| headB== null) return null;
        ListNode a = headA, b=headB;
        int lengthA = 0,lengthB=0;
        while (a!=null){
            lengthA++;
            a = a.next;
        }
        while (b!=null){
            lengthB++;
            b = b.next;
        }
        a = headA;
        b=headB;
        if (lengthA>lengthB){
            for (int i = 0; i < lengthA - lengthB; i++) {
                a = a.next;
            }
        }else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                b = b.next;
            }
        }
        while (a!=null || b!=null){
            if (a == b) return a;
            a = a.next;
            b = b.next;
        }
        return null;
    }

    /**
     * 
     * @Param
     * @Description //删除链表的倒数第N个节点
     * @Date 16:43 2022/5/2
     * @return 
     **/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null || head.next==null) return null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode fast = head, slow = dummyNode;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }

    /**
     *
     * @Param
     * @Description //反转链表：
     * way1：迭代法
     * way2：递归
     * @Date 17:12 2022/5/2
     * @return
     **/
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummyNode = null;
        ListNode prev = dummyNode, now = head, next = head.next;
        while (next!=null){
            now.next = prev;
            prev = now;
            now = next;
            next = next.next;
        }
        now.next = prev;
        return now;
    }
    public ListNode reverseList2(ListNode head) {
        if (head==null || head.next==null) return head;

        return recursionReverse(head);
    }

    //返回数组分别是，反转后的首尾节点
    private ListNode recursionReverse(ListNode head) {
        if (head.next==null) return head;

        ListNode completed = recursionReverse(head.next);
        head.next.next = head;
        head.next = null;
        return completed;
    }


    /**
     *
     * @Param
     * @Description //给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     * 思路：呀节点
     * @Date 17:50 2022/5/2
     * @return
     **/
    public ListNode removeElements(ListNode head, int val) {
        if (head==null || val<0 || val>50) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode node = head, prev = dummyNode;
        while (node!=null){
            if (node.val==val){
                prev.next = node.next;
                node = node.next;
            }else{
                node = node.next;
                prev = prev.next;
            }
        }
        return dummyNode.next;
    }

    /**
     * 
     * @Param
     * @Description //奇偶链表:给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     * 注意下面这种方法是个错误示范，因为成环了，因为直接等的话其实是同一个节点，因此同时操作多个变量的指针很容易对一个节点进行操作。
     * 已改正：错误在于将even连接于odd之后时，even最后一个的next并不为空，处理一下。
     * @Date 18:09 2022/5/2
     * @return 
     **/
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next==null) return head;
        ListNode node = head.next.next, odd = head, even = head.next, evenFisrt = even;
        boolean oddFlag = true;
        while (node!=null){
            if (oddFlag){
                odd.next = node;
                odd = odd.next;
            } else{
                even.next = node;
                even = even.next;
            }
            oddFlag = !oddFlag;
            node = node.next;
        }
        if (odd.next==null){
            even.next=null;
        }
        odd.next = evenFisrt;
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

    public static void main(String[] args) {
        ListProblem list = new ListProblem();
        ListNode listNode = list.new ListNode(1);
        ListNode old = listNode;
        for (int i = 2; i < 6; i++) {
            ListNode listNode1 = list.new ListNode(i);
            old.next = listNode1;
            old = listNode1;
        }
        ListNode ans = list.oddEvenList(listNode);
    }
    //Definition for singly-linked list.
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
}
