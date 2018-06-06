package com.leetcode.base;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 20:30 2018/6/5
 * @Modified By:
 */
//这种方法可以进行改进，例如在构造bst的时候，在节点中加入每个节点的左子树的数目n，这样在查找kth时，就可以逐个比较每个根节点的n
class KthLargest {
    private TreeNode root;
    private int m;
    private int[] arr;
    List<Integer> list = new LinkedList<>();
    public KthLargest(int k, int[] nums) {
        m=k;
        arr=nums;
        chushihua();
    }
    private void chushihua(){
        if (arr==null) root = null;
        else if (arr.length==0) root=null;
        else {
            root = new TreeNode(arr[0]);
            if (arr.length>1){
                for (int i = 1; i < arr.length; i++) {
                    insertIntoBST(root,arr[i]);
                }
            }
        }
    }

    public int add(int val) {
        insertIntoBST(root,val);
        list = inorderTraversal(root);
        return list.get(list.size()-m);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return list;
        inorder(root);
        return list;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insert(root,val);
        return root;
    }

    private void insert(TreeNode root, int val) {
        if (val<root.val) {
            if (root.left!=null) insert(root.left,val);
            else root.left = new TreeNode(val);
        }
        else {
            if (root.right!=null) insert(root.right,val);
            else root.right = new TreeNode(val);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        int k = 3;
        int[] arr =new int[]{4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
        System.out.println(Integer.MAX_VALUE);
        int a=2147483647;
        int b = -1;
        int tmp = a>b?(a-b):(b-a);
        System.out.println(tmp);
        if (tmp>2147483647) System.out.println(false);
        System.out.println(tmp>2147483647);
    }
}