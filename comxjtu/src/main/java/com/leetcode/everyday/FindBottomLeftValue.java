package com.leetcode.everyday;

import com.leetcode.util.Construct;
import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JS
 * @version 1.0
 * @date 2022/6/22 15:42
 * @description //513. 找树左下角的值
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        int ans = root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            int left_count= 0;
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = queue.poll();
                if(treeNode.left!=null) {
                    if (left_count==0){
                        ans = treeNode.left.val;
                        left_count++;
                    }
                    queue.offer(treeNode.left);
                }
                if (treeNode.right!=null){
                    if (left_count==0){
                        ans = treeNode.right.val;
                        left_count++;
                    }
                    queue.offer(treeNode.right);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = Construct.deserialize("1,2,3,4,#,5,6,#,#,7");
        int ans = new FindBottomLeftValue().findBottomLeftValue(root);
        System.out.println(ans);
    }
}
