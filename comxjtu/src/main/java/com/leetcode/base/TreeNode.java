package com.leetcode.base;

/**
 * @Author: Jay
 * @Date: Created in 10:29 2018/6/6
 * @Modified By:
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(){}
    TreeNode(int x) {
        this.val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
