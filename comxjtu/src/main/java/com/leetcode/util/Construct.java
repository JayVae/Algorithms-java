package com.leetcode.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/1 12:09
 * @description //一个工具类，用于在验证树问题的算法正确性测试时：
 * 1. 通过字符串构建二叉树；
 * 2. 通过二叉树输出对应的层序遍历的字符串。
 */
public class Construct {

        //tools for reconstruct treenode
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean isLeft = true;
        TreeNode root = null;

    /**
     *
     * @Param 字符串中的叶子节点默认用#表示，实际中自行替换
     * @Description // 通过二叉树输出对应的层序遍历的字符串。
     * @Date 12:13 2022/5/1
     * @return
     **/
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                TreeNode top = queue.poll();
                if(top == null){
                    builder.append('#');
                    builder.append(',');
                }
                else{
                    builder.append(top.val);
                    builder.append(',');//以,作为分割
                    queue.offer(top.left);
                    queue.offer(top.right);
                }
            }
            return builder.toString();
        }

    /**
     *
     * @Param 字符串中的叶子节点默认用#表示，实际中自行替换
     * @Description //通过字符串构建二叉树；
     * @Date 12:15 2022/5/1
     * @return
     **/
        public TreeNode deserialize(String data) {
            String[] strs = data.split(",");
            int size = strs.length;

            for(int i = 0;i<size;i++){
                String curstr = strs[i];
                if(curstr.length() == 0)
                    continue;
                else if(curstr.equals("#")){
                    appendNodeToTree(null);
                }else{
                    int val = Integer.parseInt(curstr);
                    appendNodeToTree(new TreeNode(val));
                }
            }
            return root;
        }
        private void appendNodeToTree(TreeNode node){
            if(root == null){
                root = node;
                queue.offer(node);
                return;
            }
            TreeNode top = queue.peek();
            if(isLeft){
                top.left = node;
            }else{
                top.right = node;
                queue.poll();
            }
            isLeft = !isLeft;//取反
            if(node != null)
                queue.offer(node);
        }
}
