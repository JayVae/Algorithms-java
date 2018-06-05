package com.leetcode.base;

/**
 * @Author: Jay
 * @Date: Created in 21:16 2018/6/4
 * @Modified By:
 */
public class BST {

    public BSTIterator(TreeNode root) {

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

    }

    /** @return the next smallest number */
    public int next() {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) return null;
        if (root.val<val) return searchBST(root.right,val);
        else if (root.val>val) return searchBST(root.left,val);
        if (root.val==val) return root;
        else return null;
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
}
