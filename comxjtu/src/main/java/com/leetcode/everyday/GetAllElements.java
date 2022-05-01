package com.leetcode.everyday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/1 10:13
 * @description //lc1305 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 */
public class GetAllElements {

    /**
     *
     * @Description 中序遍历+归并排序
     * @Date 10:16 2022/5/1
     * @return
     **/
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new LinkedList<>();
        List<Integer> result1 = midOrder(root1);
        List<Integer> result2 = midOrder(root2);
        if (result1.size()==0){
            return result2;
        }else if (result2.size()==0){
            return result1;
        }
        result = merge(result1, result2);
        return result;
    }

    private List<Integer> merge(List<Integer> result1, List<Integer> result2) {
        List<Integer> result = new LinkedList<>();
        int i = 0, j=0;
        while (i<result1.size() && j<result2.size()){
            int res1 = result1.get(i);
            int res2 = result2.get(j);
            if (res1 < res2){
                result.add(res1);
                i++;
            }else {
                result.add(res2);
                j++;
            }
            if (i==result1.size()){
                result.addAll(result2.subList(j, result2.size()));
            }
            if (j==result2.size()){
                result.addAll(result1.subList(i, result1.size()));
            }
        }
        return result;
    }

    private List<Integer> midOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }


    //Definition for a binary tree node.
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
}




