package com.xjtu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Jay
 * @Date: Created in 19:22 2018/5/24
 * @Modified By:
 */
public class Test {

    public static void main(String[] args){
        System.out.println("A man, a plan, a canal: Panama".replaceAll("\\W*",""));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println("   -42".trim());
        System.out.println('-'-0);
        System.out.println("words and 987".trim().replaceAll("\\D+","A"));
        String strr = "-4193 with words12".trim().replaceAll("\\D+","A");
//        strr = strr.substring(0,strr.indexOf('A'));
        System.out.println(strr);
        System.out.println(strr.substring(0));
        int[] a1 = new int[]{54,21,73,84,60,18,62,59,89,89,41,55,27,65,94,61,12,76,35,48,0,60,84,9,28,55,4,67,86,33};
        int[] a2 = new int[]{17,17,87,98,18,53,2,69,74,73,20,85,59,89,84,91,84,34,44,48,20,42,68,84,8,54,66,62,69,52,67,27,87,49,92,14,92,53,22,90,60,14,8,71,0,61,94,1,22,84,10,55,55,60,98,76,27,35,84,28,4,2,9,44,86,12,17,89,35,68,17,41,21,65,59,86,42,53,0,33,80,20};
        Arrays.sort(a1);
        Arrays.sort(a2);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println("[0,4,9,12,18,21,27,28,33,35,41,48,54,55,55,59,60,60,61,62,65,67,73,76,84,84,84,84,84,86,89,89,94]");
        String s1 = "";
        String s2 = " ";
        int[] arr = new int[]{1,1,3,5,7,2};
        System.out.println(Arrays.binarySearch(arr,7));
        System.out.println(Arrays.toString(arr));
        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
        System.out.println('('+0);
        System.out.println(')'+0);
        System.out.println('['+0);
        System.out.println(']'+0);
        System.out.println('{'+0);
        System.out.println('}'+0);
        System.out.println("..........");
        Integer n1 = 10;
        Integer n2 = 10;
        Set leftset = new HashSet<Character>();
        leftset.add('a');
        leftset.add('a');
        leftset.add('a');
        System.out.println(leftset.size());
        System.out.println(']'-'(');
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode()==s2.hashCode());

//        int a =9646324351;
        String str = "-123456";
        System.out.println(str);
        char[] chr = str.toCharArray();
        System.out.print(chr[0]);
        for (int i = 0; i < chr.length; i++) {
            System.out.print(chr[chr.length-i-1]);
        }
        System.out.println();
        if (chr[0]=='-'){
            for (int i = 1; i < chr.length/2+1; i++) {
                char tmp = chr[i];
                chr[i] = chr[chr.length-i];
                chr[chr.length-i] = tmp;
            }
        }else {
            for (int i = 0; i < chr.length / 2; i++) {
                char tmp = chr[i];
                chr[i] = chr[chr.length-1-i];
                chr[chr.length-1-i] = tmp;
            }
        }
        int a=0;
        try{
            a = Integer.valueOf(String.valueOf(chr));
        }catch (Exception e){
            System.out.println(0);
        }
        System.out.println(a);

    }

}
