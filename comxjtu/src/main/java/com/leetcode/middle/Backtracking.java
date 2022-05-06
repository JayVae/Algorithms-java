package com.leetcode.middle;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 20:40 2018/6/13
 * @Modified By:
 */
public class Backtracking {
    /**
     * 电话号码的字母组合
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits.length()==0) return result;
        String[] dict = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String first = dict[(int)digits.charAt(0)-2-48];
        for (int i = 0; i < first.length(); i++) {
            result.add(first.charAt(i)+"");
        }
        for (int i = 1; i < digits.length(); i++) {
            int len = result.size();
            for (int j = 0; j < len; j++) {
                String tmp = result.remove(0);
                String now = dict[(int)digits.charAt(i)-2-48];
                for (int k = 0; k < now.length(); k++) {
                    result.add(tmp+now.charAt(k));
                }
            }
        }
        return result;
    }

    public List<String> letterCombinations2(String digits) {
        if (digits == null) return null;
        List<String> result = new LinkedList<>();
        if (digits.length() ==0) return result;

        String[] dict = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(result, digits, dict,0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, String digits, String[] dict, int itrDigits, StringBuilder stringBuilder) {
        if (itrDigits==digits.length()){
            result.add(stringBuilder.toString());
            return;
        }
        String string = dict[digits.charAt(itrDigits)-'2'];
        for (int i = 0; i < string.length(); i++) {
            int size = stringBuilder.length();
            stringBuilder.append(string.charAt(i));
            backtrack(result, digits,dict,itrDigits+1, stringBuilder);
            stringBuilder.delete(size,size+1);
        }
    }

    /**
     * lc46
     * 全排列:
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new LinkedList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new LinkedList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * lc47
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(list, new LinkedList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length) list.add(new LinkedList<>(tempList));

        for(int i = 0; i < nums.length; i++){
            //若在同一层已经遍历过（就是循环过了），则跳过这次
            if(i > 1 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            //这个if判断类似于全排列中的if(tempList.contains(nums[i]))，不能漏掉
            if (!used[i]){
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * lc77 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack2(result, new LinkedList<>(), n, k, 1);
        return result;
    }

    //i代表的是当前遍历到的节点，每个节点深度遍历的时候只遍历后面的节点
    private void backtrack2(List<List<Integer>> result, List<Integer> list, int n, int k, int i) {
        if (list.size()==k){
            result.add(new LinkedList<>(list));
            return;
        }
        for (int j = i; j < n+1; j++) {
            //不用判断是否遍历过，之前的都遍历过了
            list.add(j);
            backtrack2(result, list, n, k, j+1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * lc39
     * 组合求和(可以用重复数字)
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * lc40
     * 组合求和：不可以用重复数字
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackSum2(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    private void backtrackSum2(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrackSum2(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * lc131
     * 分割回文串
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
        if(start == s.length())
            list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
    /**
     * 生成括号:给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * 思路：
     在构造这个字符串时需要满足左括号的个数不能少于右括号的个数。
     当左括号的个数小于右括号个数时，返回
     当左括号个数和右括号个数均为n时，表示得到一个有效的字符串，将其push到vector中；
     当左括号个数等于n而右括号个数不为n时，在字符串中添加右括号知道右括号个数为n；
     否则随意添加左右括号。
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        backtrack(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, StringBuilder str, int open, int close, int max){
        if(str.length() == max*2){
            list.add(str.toString());
            return; }
        if(open < max) {
            backtrack(list, str.append("("), open+1, close, max);
            str.delete(str.length()-1, str.length());
        }
        if(close < open) {
            backtrack(list, str.append(")"), open, close+1, max);
            str.delete(str.length()-1, str.length());
        }
    }

    /**
     * lc78
     * 子集：给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 方法一使用了类似的穷举法；
     * 方法二使用了回溯法的递归实现。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        backtrack(result, new LinkedList<Integer>(),nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, LinkedList<Integer> list, int[] nums, int i) {
        if (i==nums.length) return;

        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            result.add(new LinkedList<>(list));
            backtrack(result, list, nums, j+1);
            list.removeLast();
        }
    }

    /**
     * lc90
     * 子集2：给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**lc79
     * 单词搜索：给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * @param board
     * @param word
     * @return
     */
    class Solution {
        public boolean exist(char[][] board, String word) {
            boolean[][] used = new boolean[board.length][board[0].length];
            boolean flag = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    flag = backtrack(board,word,used,i,j,0);
                    if (flag) return true;
                }
            }
            return flag;
        }

        private boolean backtrack(char[][] board, String word, boolean[][] used, int startX, int startY, int wordIndex) {
            if (wordIndex>=word.length()) return true;
            if (startX<0 || startX>board.length-1 || startY<0 || startY>board[0].length-1) return false;


            if (!used[startX][startY]){
                if (word.charAt(wordIndex)==board[startX][startY]){
                    used[startX][startY]= true;
                    boolean left = backtrack(board, word, used, startX-1, startY, wordIndex+1);
                    boolean right = backtrack(board, word, used, startX+1, startY, wordIndex+1);
                    boolean up = backtrack(board, word, used, startX, startY+1, wordIndex+1);
                    boolean down = backtrack(board, word, used, startX, startY-1, wordIndex+1);
                    if(left || right || up || down) return true;
                    used[startX][startY]= false;
                }
            }
            return false;

        }
    }

    int[][] dir = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};
    int m,n;

    public boolean exist2(char[][] board, String word) {
        char[] chars = word.toCharArray();
        m = board.length;
        n= board[0].length;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(chars,0,board,i,j,visited))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[] chars, int index, char[][] board,int startx, int starty,boolean[][] visited) {
        if (index==chars.length-1){
            return chars[index]==board[startx][starty];
        }
        if (board[startx][starty]==chars[index]){
            visited[startx][starty]=true;
            for (int i = 0; i < 4; i++) {
                int newx = startx+dir[i][0];
                int newy = starty+dir[i][1];
                if (!visited[newx][newy] && newx>=0 && newy>=0 && newx<m && newy<n){
                    if (backtrack(chars,index+1,board,newx,newy,visited))
                        return true;
                }
            }
            visited[startx][starty]=false;
        }
        return false;
    }

    /**
     * lc200
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

    public static void main(String[] args){
//        int i=0;
//        String tmp = Integer.toBinaryString(i);
//        System.out.println(tmp.length());
//        String tmp2 = Integer.toBinaryString(7);
//        System.out.println(tmp2.length());
//        int[] nums = new int[]{1,2,3};
        Backtracking bp = new Backtracking();
//        List<List<Integer>> result=bp.subsets(nums);
        List<String> result = bp.letterCombinations2("23");
    }
}
