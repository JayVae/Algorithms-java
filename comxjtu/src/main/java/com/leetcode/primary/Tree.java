package com.leetcode.primary;

import java.util.*;

/**
 * @Author: Jay
 * @Date: Created in 9:18 2018/5/31
 * @Modified By:
 */

/**
 * 最大深度，isValidBST，isSymmetric,hasPathSum,验证二叉搜索树
 *
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

    public boolean isValidBST3(TreeNode root) {

        if (root == null) {
            return true;
        }

        list = new ArrayList<>();
        inOrder(root);
        for (int i = 0; i < list.size()-1; i++) {
            if ((int)list.get(i)>=(int)list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    /**
     * 如果是一棵二叉查找树，必是有序的,中序遍历
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * 方法一是中序遍历（看构成的数组是不是前后对称的，但是这种方法是有问题的，会对所有叶子节点的左右节点添加-1），
     * 方法二是递归，
     * 方法三是迭代方法，借鉴层级遍历的方法
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
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    /**
     * 判断一颗二叉树的左右两子节点是否对称
     * @param leftNode 左子节点
     * @param rightNode 右子节点
     * @return true：对称 false：不对称
     */
    public boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (
                (leftNode != null && rightNode == null) ||
                        (leftNode == null && rightNode != null) ||
                        leftNode.val != rightNode.val ||
                        !isMirror(leftNode.left, rightNode.right) ||
                        !isMirror(leftNode.right, rightNode.left)) {
            return false;
        } else {
            return true;
        }
    }
    public boolean isSymmetric3(TreeNode root) {
        TreeNode t1 =root;
        TreeNode t2 =root;
        Queue<TreeNode> q = new LinkedList<>();
        if (root==null) return true;
        if (root.left==null || root.right==null){
            if (root.left==null && root.right==null)
                return true;
            return false;
        }
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()){
            t1 = q.poll();
            t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        else if (root.left == null && root.right == null) {
            return sum == root.val;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
}
