package com.leetcode.base;

import java.util.Stack;

/**
 * @Author: Jay
 * @Date: Created in 10:29 2018/6/6
 * @Modified By:
 */

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 调用 next() 将返回二叉搜索树中的下一个最小的数。
 注意: next() 和hasNext() 操作的时间复杂度是O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 */
public class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        if (root == null){
            return ;
        }
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int ans = node.val;
        if (node.right != null){
            node = node.right;
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return ans;
    }
}
