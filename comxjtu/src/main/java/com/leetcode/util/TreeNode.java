package com.leetcode.util;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/1 12:10
 * @description //TODO
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
