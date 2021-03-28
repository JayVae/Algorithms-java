package com.company.xiaomi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int cnt = 0;
            Map<Integer, List<String>> map = new HashMap<>();
            while (!in.nextLine().equals("END")) {
                String s = in.nextLine();
                String[] stings = s.split("#");
                int base = Integer.valueOf(stings[0]);
                int num = Integer.valueOf(stings[1]);
                if (base != 10) {
                    num = Integer.parseInt(stings[1], base);
                }
                if (map.containsKey(num)) {
                    List<String> tmp = map.get(num);
                    tmp.add(s);
                    map.put(num, tmp);
                } else {
                    List<String> tmp = new LinkedList<String>();
                    tmp.add(s);
                    map.put(num, tmp);
                }
                cnt++;
            }
            for (Integer key : map.keySet()) {
                if (map.get(key).size() == 1) {
                    System.out.println(map.get(key).get(0));
                    break;
                }
            }
        }
    }

}
