package com.interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvailableSet {

    public static void main(String[] args) {
        AvailableSet availableSet = new AvailableSet();
        availableSet.combinations( new ArrayList<>(),Arrays.asList(1,2,3,4), 2);
        availableSet.combinations( new ArrayList<>(), new ArrayList<>(), 2);
        availableSet.combinations( new ArrayList<>(), new ArrayList<>(), 0);
        availableSet.combinations( new ArrayList<>(),Arrays.asList(1,2,3,4), 1);
        availableSet.combinations( new ArrayList<>(),Arrays.asList(1,2,3,4), 0);
        availableSet.combinations( new ArrayList<>(),Arrays.asList(1,2,3,4,5,6,7,8,9,10), 4);
    }

    public void combinations(List<Integer> selected, List<Integer> data, int n) {

        if (n == 0){
            for (Integer i :
                    selected) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }

        if (data.isEmpty()){
            return;
        }

        selected.add(data.get(0));
        combinations(selected, data.subList(1, data.size()), n-1);

        //selected.remove(data.get(0));
        selected.remove(selected.size()-1);
        combinations(selected, data.subList(1, data.size()), n);
    }
}
