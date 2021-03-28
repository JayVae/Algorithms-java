package com.algorithom4.ch2;

/**
 * @Author: Jay
 * @Date: Created in 14:25 2018/5/21
 * @Modified By:
 */

/**
 * 堆实现优先队列
 * 改进之处：
 *  1.多叉堆
 *  2.调整数组大小
 *  3.索引优先队列
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1,N--);
        pq[N+1]=null;
        sink(1);
        return max;
    }

    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    private void exch(int i, int j){
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    public void swim(int k){
        while(k>1 && less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }

    public void sink(int k){
        while(2*k < N ){
            int j = 2*k;
            if (j<N && less(j,j+1)) j++;
            if (!less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }
}
