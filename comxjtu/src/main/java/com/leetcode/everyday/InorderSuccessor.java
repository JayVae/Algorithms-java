package com.leetcode.everyday;

import com.leetcode.util.TreeNode;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/16 9:07
 * @description //面试题 04.06. 后继者
 */
public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        return inorder(root, p);
    }

    private TreeNode inorder(TreeNode root, TreeNode p) {
        if (root == null) return null;

        TreeNode post = inorder(root.right, p);
        if (root == p) return post;
        else {
            TreeNode pre = inorder(root.left, p);
            post = inorder(root.right, p);
        }

        return post;
    }
}


