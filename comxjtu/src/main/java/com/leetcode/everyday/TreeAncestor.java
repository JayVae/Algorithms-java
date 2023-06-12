package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/12 10:23
 * @description //1483. 树节点的第 K 个祖先
 * 由于任意k 可以分解为若干不同的2 的幂（例如  13=8+4+1），所以只需要预处理出这些2^i祖先节点，就可以快速地到达任意第k 个祖先节点。
 */
public class TreeAncestor {

    int[] parent;
    int n;
    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        this.parent = parent;
    }

    public int getKthAncestor(int node, int k) {
        int count = 0;
        while (count<k){
            if (parent[node]!=-1){
                node = parent[node];
                count++;
            }else {
                node = -1;
                break;
            }
        }
        return node;
    }
}
