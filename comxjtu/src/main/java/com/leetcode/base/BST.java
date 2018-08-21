package com.leetcode.base;

/**
 * @Author: Jay
 * @Date: Created in 21:16 2018/6/4
 * @Modified By:
 */

/**
 * 在二叉搜索树中实现搜索、插入、删除
 * 二叉搜索树的最近公共祖先
 * 将有序数组转换为二叉搜索树
 * 判断它是否是高度平衡的二叉树。
 */
public class BST {
    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * 每次需要确定一下上下界
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean valid(TreeNode node,long mn,long mx) {
        if(node == null)
            return true;

        if(node.val <= mn || node.val >= mx) {
            return false;
        }
        return valid(node.left,mn,node.val) && valid(node.right,node.val,mx);
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

    /**
     * 这个程序有点问题，主要是对递归的过程没有理解清楚，方法参考https://blog.csdn.net/byamao1/article/details/53067478和https://blog.csdn.net/qq508618087/article/details/53421696
     * 下面第二个方法是正确的
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.left == null && root.right==null){
            if (root.val==key) return null;
            else return root;
        }else if (root.left==null){
            if (root.val==key) return root.right;

        }else if (root.right==null){
            if (root.val==key) return root.left;

        }
        delete(root,root,key);
        return root;
    }
    private void delete(TreeNode root,TreeNode pre, int key){
        //没有考虑key不在其中的情况
        if (root==null) return;
        if (key<root.val) delete(root.left,root,key);
        else if (key>root.val) delete(root.right,root,key);
        else if (key==root.val){
            if (root.left==null && root.right==null){
                    if (key>pre.val) pre.right = null;
                    else pre.left = null;
            }else if (root.left==null){
                if (key>pre.val) pre.right=root.right;
                else pre.left = root.right;
            }else if (root.right==null){
                if (key>pre.val) pre.right=root.left;
                else pre.left = root.left;
            }else {
                if (root.right.left==null){
                    if (root.right.right==null){
                        swap(root,root.right);
                        root.right =null;
                    }else {
                        swap(root,root.right);
                        root.right=root.right.right;
                    }
                }
                else{
                    TreeNode min = findMin(root.right,root.right);
                    swap(root,min);
                    min.left = null;
                }
            }
        }
        else return;
    }
    private void swap(TreeNode node1, TreeNode node2){
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
    private TreeNode findMin(TreeNode right,TreeNode pre){
        if (right.left==null) return pre;
        else return findMin(right.left,right);
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        //require
        if(root==null)
            return root;
        //invariant
        if(key<root.val)
            root.left=deleteNode1(root.left,key);
        else if(root.val<key)
            root.right=deleteNode1(root.right,key);
        else{
            //two children
            if(root.left!=null&&root.right!=null){
                TreeNode tmp=findMin(root.right);
                root.val=tmp.val;
                root.right=deleteNode1(root.right,root.val);
            }else{
                //one child or zero
                if(root.left==null)
                    root=root.right;
                else
                    root=root.left;
            }
        }
        //ensure
        return root;
    }
    private TreeNode findMin(TreeNode root){
        while(root.left!=null)
            root=root.left;
        return root;
    }

    /**
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums==null || nums.length==0) return false;
        for (int i = 1; i < k+1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j+i>=nums.length) break;
                int tmp = nums[j]>nums[j+i]?(nums[j]-nums[j+i]):(nums[j+i]-nums[j]);
                if (tmp<0) return true;
                if (tmp<=t) return true;
            }
        }
        return false;
    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     */
    private boolean isBalanced=true;
    public boolean IsBalanced_Solution(TreeNode root) {

        getDepth(root);
        return isBalanced;
    }
    public int getDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);

        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return right>left ?right+1:left+1;

    }

    /**
     * 将有序数组转换为二叉搜索树
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return getTree(nums,0,nums.length - 1);
    }
    public TreeNode getTree(int []nums,int l,int r){
        if(l <= r){
            int mid = (l+r)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = getTree(nums,l,mid-1);
            node.right = getTree(nums,mid+1,r);
            return node;
        }else{
            return null;
        }
    }


    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 思路：三种情况：
     *  1.均在左子树中；2.均在右子树中；3.在左右两棵树
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p) return p;
        if(root == q) return q;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        return left != null ? left : right;
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
