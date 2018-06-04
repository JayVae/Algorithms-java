package com.leetcode.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: Jay
 * @Date: Created in 17:06 2018/6/1
 * @Modified By:
 */
public class Tree {
    /**
     * 前序遍历
     * @param root
     * @return
     */
    List<Integer> list = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null) return list;
        preorder(root);
        return list;
    }
    private void preorder(TreeNode root){
        if (root==null) return;
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) return list;
        inorder(root);
        return list;
    }
    private void inorder(TreeNode root){
        if (root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return list;
    }
    private void postorder(TreeNode root){
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }

    Queue queue = new LinkedBlockingQueue();
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

        levelOrder(root);
        return result;
    }
    private void levelorder(Queue queue){
        if (queue==null) return;
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
