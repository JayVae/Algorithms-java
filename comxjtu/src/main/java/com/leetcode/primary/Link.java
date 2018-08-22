package com.leetcode.primary;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 17:20 2018/5/30
 * @Modified By:
 */

/**
 * 包括读取数组，输出成list的辅助函数。
 * 删除某个节点
 * lc203 删除节点（虚拟节点的技术）
 * 反转
 * 有环1,2
 * 相交
 * 奇偶链表见middle
 */
public class Link {

    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾的）节点，您将只被给予要求被删除的节点。
     比如：假设该链表为 1 -> 2 -> 3 -> 4  ，给定您的为该链表中值为 3 的第三个节点，那么在调用了您的函数之后，该链表则应变成 1 -> 2 -> 4 。
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node==null) return;
        if (node.next==null) return;
        else {
            ListNode next = node.next;
            node.val=next.val;
            node.next=next.next;
            next.next=null;
        }
    }

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        if (n<=0) return head;
        if (head.next==null && n==1) return null;
        ListNode l = head;
        ListNode last = head;
        int now = 1;
        ListNode delnode = head;
        while (l.next!=null){
            if (n==1) last=l;
            l = l.next;
            now++;
            if (now>n){
                delnode = delnode.next;
            }
        }
        if (n==1){
            last.next=null;
        }else {
            deleteNode(delnode);
        }

        if (now==n){
            return delnode;
        }else {
            return head;
        }
    }
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
    /**
     * 反转一个单链表。
     示例:
     输入: 1->2->3->4->5->NULL
     输出: 5->4->3->2->1->NULL
     进阶:
     你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return head;
        ListNode now = head;
        ListNode first = new ListNode(head.val);
        first.next = null;
        while (now.next!=null){
            now = now.next;
            ListNode oldfirst = first;
            first = new ListNode(now.val);
            first.next = oldfirst;
        }
        return first;
    }

    /**
     * 请判断一个链表是否为回文链表。
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head==null) return true;
        if (head.next==null) return true;
        ListNode l = head;
        List<Integer> list = new ArrayList<Integer>();
        list.add(l.val);
        while (l.next!=null){
            l=l.next;
            list.add(l.val);
        }
        for (int i = 0; i < list.size()/2; i++) {
            System.out.println(list.get(i));
            System.out.println(list.get(list.size()-1-i));
            if ((int)list.get(i)!=(int)list.get(list.size()-1-i)) return false;
        }
        return true;
    }

    /**lc141
     * 给定一个链表，判断链表中是否有环。
     进阶：
     你能否不使用额外空间解决此题？
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null) return false;
        ListNode next = head;
        ListNode next2 = head;
        while ( next.next!=null && next2.next!=null && next2.next.next!=null){
            next = next.next;
            next2 = next2.next.next;
            if (next==next2) return true;
        }
        return false;
    }

    /**
     * lc142
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    /**
     * lc160
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }


    public static void main(String[] args){
        Link link = new Link();
        ListNode l = link.readList(new int[]{-129,-129});
        link.outList(l);
        System.out.println(link.isPalindrome(l));
        ListNode l2= link.removeNthFromEnd(l,1);
        link.outList(l2);

    }

    public ListNode readList(int[] nums){
        ListNode first = new ListNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            ListNode oldfirst = first;
            first = new ListNode(nums[i]);
            first.next = oldfirst;
        }
        return first;
    }
    public void outList(ListNode listNode){
        ListNode l = listNode;
        System.out.print("[");
        if (l==null) return;
        System.out.print(l.val+" ");
        while (l.next!=null){
            l=l.next;
            System.out.print(l.val+" ");
        }
        System.out.println("]");
    }

    public class ListNode {
        int val;
        ListNode next;
        boolean visible;

        public void setVisible(boolean visible) {
            this.visible = visible;
        }

        ListNode(int x) {
            val = x;
        }
    }
}
