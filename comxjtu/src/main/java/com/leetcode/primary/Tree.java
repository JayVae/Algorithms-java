package com.leetcode.primary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Jay
 * @Date: Created in 9:18 2018/5/31
 * @Modified By:
 */
public class Tree {
    /**
     * 给定一个二叉树，找出其最大深度。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return  maxDepth2(root);
    }
    private int maxDepth2(TreeNode root){
        if (root==null) return 0;
        int h1 = maxDepth2(root.left);
        int h2 = maxDepth2(root.right);
        int height = h1>h2?h1:h2;
        return height+1;
    }

    /**
     * 验证二叉搜索树（下面这个方法是错的。。。），方法二三分别是递归和中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        LinkedList<Integer>  list = new LinkedList<Integer>();
        return isValid(root);
    }
    private boolean isValid(TreeNode root){
        if (root==null) return true;
        boolean flag = false;

        if (root.left==null){
            if (root.right==null) return true;
            else if (root.right.val>root.val) return isValid(root.right);
            else return false;
        }else {
            if (root.right==null) {
                if (root.left.val<root.val) return isValid(root.left);
                else return false;
            }else {
                if (root.left.val<root.val && root.right.val>root.val) return isValid(root.left)&&isValid(root.right);
                else return false;
            }
        }
    }

    public boolean isValidBST2(TreeNode root) {
        if(root == null)
            return true;

        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean valid(TreeNode node,long mn,long mx) {
        if(node == null)
            return true;

        if(node.val <= mn || node.val >= mx) {
            return false;
        }
        return valid(node.left,mn,node.val) && valid(node.right,node.val,mx);
    }

    private Stack<Integer> stack;
    public boolean isValidBST3(TreeNode root) {

        if (root == null) {
            return true;
        }

        stack = new Stack<>();
        inOrder(root);

        int i = stack.pop();
        int j;
        while (!stack.isEmpty()) {
            j = stack.pop();
            if (i <= j) {
                return false;
            }

            i = j;
        }

        return true;
    }
    /**
     * 如果是一棵二叉查找树必必是有序的,中序遍历
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            stack.push(root.val);
            inOrder(root.right);
        }
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * @param root
     * @return
     */
    ArrayList list = new ArrayList<Integer>();
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        inOrder2(root);
        int len = list.size();
        for (int i = 0; i < len/2; i++) {
            System.out.println("["+(int)list.get(i)+"_"+(int)list.get(len-1-i)+"]");
            if ((int)list.get(i)!=(int)list.get(len-1-i))  return false;
        }
        return true;
    }
    public void inOrder2(TreeNode root) {
        if (root != null) {
            inOrder2(root.left);
            list.add(root.val);
            inOrder2(root.right);
        }else {
            list.add(-1);
        }
    }

    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return null;
        List<List<Integer>> list = new LinkedList<>();
        ArrayList<Integer> l1= new ArrayList();
        l1.add(1);
        list.add(l1);
        return list;
    }

    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return new TreeNode(1);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}