package com.N360;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int q = in.nextInt();
            for (int i = 0; i < q; i++) {
                int begin = in.nextInt()-1;
                int end = in.nextInt()-1;
                Set<Integer> set = new HashSet<>();
                for (int j = begin; j <= end; j++) {
                    if (!set.contains(a[j])){
                        set.add(a[j]);
                    }
                }
                System.out.println(set.size());
            }
        }
    }
}
