package com.leetcode.everyday;

import com.leetcode.base.TreeNode;

import java.util.ArrayList;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/24 12:25
 * @description //TODO
 */
public class LevelOrder {

//    这种写法是有问题的
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // 二叉树层序遍历
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<TreeNode> temp = new ArrayList<>();
            for (TreeNode node : queue) {
                list.add(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }

            }
            res.add(list);
            queue = temp;
        }
        return res;
    }
}
