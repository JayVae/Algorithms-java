package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 17:40 2018/7/14
 * @Modified By:
 */
public class lc226 {

    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;

        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.left = left;
        root.right = right;
        return root;
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
