package com.xjtu.ch3;

/**
 * @Author: Jay
 * @Date: Created in 20:11 2018/5/23
 * @Modified By:
 */
public class BinarySearchST<Key extends Comparable<Key>,Value> {

    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int cap){
        keys = (Key[]) new Comparable[cap];
        values = (Value[]) new Object[cap];
    }

    public int size(){
        return N;
    }

    public Value get(Key key){
        if (isEmpty()) return null;
        int i = rank(key);
        if (i<N && keys[i].compareTo(key)==0) return values[i];
        else return null;
    }

    public void put(Key key,Value value){
        int i = rank(key);
        if (i<N && keys[i].compareTo(key)==0){
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    private int rank(Key key) {
        int lo = 0, hi = N-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int res = key.compareTo(keys[mid]);
            if (res<0) hi = mid -1;
            else if (res > 0) lo = mid +1;
            else return mid;
        }
        return lo;
    }

    public void delete(Key key ){
        put(key,null);
    }

    public boolean contains(Key key){
        return get(key)!=null;
    }

    public boolean isEmpty(){
        return size()==0;
    }
}
