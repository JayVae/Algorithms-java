package com.leetcode.middle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Jay
 * @Date: Created in 19:27 2018/6/13
 * @Modified By:
 */
public class TreeandGraph {
    /**
     * 二叉树的锯齿形层次遍历,即之字形遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            List<Integer> tmp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode now = queue.poll();
/*                if (flag){
                    if (now.right!=null) queue.add(now.right);
                    if (now.left!=null) queue.add(now.left);
                }else {
                    if (now.left!=null) queue.add(now.left);
                    if (now.right!=null) queue.add(now.right);
                }*/
                if (now.left!=null) queue.add(now.left);
                if (now.right!=null) queue.add(now.right);
                tmp.add(now.val);
            }
            int len = tmp.size();
            if (flag){
                for (int i = 0; i < len; i++) {
                    list.add(tmp.get(len-1-i));
                }
                result.add(list);
            }else {
                result.add(tmp);
            }

//            result.add(list);
            flag = !flag;
        }
        return result;
    }

    /**
     * 二叉搜索树中第K小的元素:给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
     * @param root
     * @param k
     * @return
     */
    List<Integer> list = new LinkedList<>();
    public int kthSmallest(TreeNode root, int k) {
        intranverse(root);
        return list.get(k-1);
    }
    private void intranverse(TreeNode root){
        if (root==null) return;
        intranverse(root.left);
        list.add(root.val);
        intranverse(root.right);
    }

    /**
     * 岛屿的个数：
     * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
     * @param grid
     * @return
     */
    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
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
