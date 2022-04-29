package com.leetcode.everyday;

import com.sun.org.apache.bcel.internal.generic.I2F;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JS
 * @version 1.0
 * @date 2022/4/29 11:15
 * @description lc427：
 * 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
 * 你需要返回能表示矩阵的 四叉树 的根结点。
 */
public class QuadTree {

    public Node construct(int[][] grid) {
        Node root = new Node();
        int length = grid.length ;
        //TODO:length为0时怎么办

        if (length<=1){
            root.isLeaf = true;
            root.val = grid[0][0]==1 ? true : false;
            return root;
        }

        root = constructChild(grid,0,0,length);

        return root;
    }

    private Node constructChild(int[][] grid, int startX, int startY, int length) {
        Node parent = new Node();
        if (length==1){
            parent.isLeaf = true;
            parent.val = grid[startX][startY]==1 ? true : false;
            return parent;
        }
        length = length/2;
        Node topLeft = constructChild(grid, startX, startY, length);
        Node topRight = constructChild(grid, startX, startY+length, length);
        Node bottomLeft = constructChild(grid, startX+length, startY, length);
        Node bottomRight = constructChild(grid, startX+length, startY+length, length);

        int ans = 0;
        ans += topLeft.val ? 1 :0;
        ans += topRight.val ? 1 :0;
        ans += bottomLeft.val ? 1 :0;
        ans += bottomRight.val ? 1 :0;

        if ((topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) && (ans==0 || ans==4)){
            parent.val = topLeft.val;
            parent.isLeaf = true;

        }else {
            parent.topLeft = topLeft;
            parent.topRight = topRight;
            parent.bottomLeft = bottomLeft;
            parent.bottomRight = bottomRight;
            parent.val = true;
        }
        return parent;
    }

    /**
     * @Description 节点定义
     * @Date 11:33 2022/4/29
     **/
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public void outResult(Node root){

        levelOrder(root);
    }

    private List<int[]> levelOrder(Node root){
        List<int[]> resList = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null){
            return resList;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int[] res = {0,1};
            if (node.isLeaf) res[0]=1;
            res[1]=node.val ? 1 : 0;
            resList.add(res);
            System.out.print(Arrays.toString(res)+",");
            if (node.topLeft != null) queue.add(node.topLeft);
            if (node.topRight != null) queue.add(node.topRight);
            if (node.bottomLeft != null) queue.add(node.bottomLeft);
            if (node.bottomRight != null) queue.add(node.bottomRight);
        }
        System.out.println();
        return resList;
    }

}
