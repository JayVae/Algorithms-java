package com.leetcode.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: Jay
 * @Date: Created in 11:29 2018/5/28
 * @Modified By:
 */
public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static MergeTwoLists.ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        MergeTwoLists.ListNode dummyRoot = new MergeTwoLists.ListNode(0);
        MergeTwoLists.ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new MergeTwoLists.ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(MergeTwoLists.ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            MergeTwoLists.ListNode l1 = stringToListNode(line);
            line = in.readLine();
            MergeTwoLists.ListNode l2 = stringToListNode(line);

            MergeTwoLists.ListNode ret = new MergeTwoLists().mergeTwoLists(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
