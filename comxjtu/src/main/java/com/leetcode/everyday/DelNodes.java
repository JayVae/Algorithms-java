package com.leetcode.everyday;

import com.leetcode.util.Construct;
import com.leetcode.util.TreeNode;
import lombok.val;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/30 9:01
 * @description //1110. 删点成林
 */
public class DelNodes {
//    记录答案
    List<TreeNode> ans = new LinkedList<>();
//    记录要删除的节点，为了方便查找，用set
    Set<Integer> deleteSet = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
//        将要删除的节点放入set
        for (int i : to_delete) {
            deleteSet.add(i);
        }
//        判断根节点是否要删除,如果不删除，就加入答案
        boolean delete = deleteSet.contains(root.val);
        if (!delete){
            ans.add(root);
        }
//        递归遍历
        bfs(root,delete);
        return ans;
    }

    private void bfs(TreeNode root, boolean delete) {
        if (root==null) return;
//        判断左右子节点是否要删除，如果要删除，就递归删除，如果不删除，判断是否加入答案。
//        是否加入答案的依据是，如果父节点要删除，那么子节点就是新的根节点，加入答案，否则不加入答案
        if (root.left!=null){
            if (deleteSet.contains(root.left.val)){
                bfs(root.left, true);
                root.left=null;
            }else {
                if (delete) ans.add(root.left);
                bfs(root.left, false);
            }
        }
        if(root.right != null ){
            if (deleteSet.contains(root.right.val)){
                bfs(root.right, true);
                root.right=null;
            }else {
                if (delete) ans.add(root.right);
                bfs(root.right, false);
            }
        }
    }

    public static void main(String[] args) {
        val to_delete = new int[]{3,5};
        Construct construct = new Construct();
        TreeNode treeNode = construct.deserialize("1,2,3,4,5,6,7");
        List<TreeNode> ansNow = new DelNodes().delNodes(treeNode, to_delete);
        for (TreeNode node : ansNow) {
            String serialize = construct.serialize(node);
            System.out.printf("serialize = " + serialize + "\n");
        }
        System.out.printf("end");
    }
}
