package com.leetcode.everyday;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/30 8:14
 * @description //1022. 从根到叶的二进制数之和
 */
public class SumRootToLeaf {


    int sum=0;
    List<String> ansList = new LinkedList<>();
    public int sumRootToLeaf(TreeNode root) {
        if (root==null) return sum;
        String ans = "";
        recursion(root,ans);
        return sum;
    }

    private void recursion(TreeNode root,String ans) {
        if (root.left==null && root.right==null) {
            ans+=root.val;
            sum+=Integer.parseInt(ans, 2);
            ansList.add(ans);
            return;
        }
        ans+=root.val;
        if (root.left!=null) recursion(root.left, ans);
        if (root.right!=null)recursion(root.right, ans);
    }
}
