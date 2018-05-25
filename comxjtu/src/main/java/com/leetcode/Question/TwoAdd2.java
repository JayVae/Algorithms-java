package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 14:59 2018/5/25
 * @Modified By:
 */
public class TwoAdd2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;
        int i1 = l1.val;
        int i2 = l2.val;
        if (i1==0 && l1.next==null && i2==0 && l2.next==null){
            return l1;
        }else if (i1==0 && l1.next==null){
            return l2;
        }else if (i2==0  && l2.next==null){
            return l1;
        }
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode ans = new ListNode(i1+i2);
        int jinwei = 0;
        if ((i1+i2)>9){
            ans = new ListNode(i1+i2-10);
            jinwei=1;
        }
        ListNode last = ans;
        while (t1.next!=null || t2.next!=null){
            if (t1.next==null) {
                i1=0;
                t2=t2.next;
                i2=t2.val;
            }
            else if (t2.next==null){
                i2=0;
                t1=t1.next;
                i1=t1.val;
            } else {
                t1=t1.next;
                t2=t2.next;
                i1=t1.val;
                i2=t2.val;
            }
            ListNode oldlast = last;
            int tr = i1+i2+jinwei;
            if (tr>9) {
                tr = tr-10;
                jinwei = 1;
            }else {
                jinwei=0;
            }
            last = new ListNode(tr);
//            System.out.print(" "+k%10);
            oldlast.next=last;
        }
        if (jinwei==1){
            ListNode oldlast = last;
            last = new ListNode(jinwei);
//            System.out.print(" "+k%10);
            oldlast.next=last;
        }
        return ans;
    }

    public ListNode trans(long k){
        ListNode ans = new ListNode((int) (k%10));
        System.out.print(k%10);
        ListNode last = ans;
        k = k/10;
        while (k!=0){
            ListNode oldlast = last;
            last = new ListNode((int) (k%10));
            System.out.print(" "+k%10);
            oldlast.next=last;
            k = k/10;
        }
        System.out.println();
        return ans;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val=x;}
    }

    public void show(ListNode l){
        while (l!=null){
            System.out.print(" "+l.val);
            l=l.next;
        }
        System.out.println();
    }

}
