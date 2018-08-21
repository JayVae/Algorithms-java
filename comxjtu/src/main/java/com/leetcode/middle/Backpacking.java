package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 20:40 2018/6/13
 * @Modified By:
 */
public class Backpacking {
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

    /**
     * lc46
     * 全排列:
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<Integer>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
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
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
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
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        if (n<1 || k<1 || n<k) return list;
        // Arrays.sort(nums); // not necessary
        backtrack(n, k,1, new ArrayList<Integer>());
        return list;
    }

    private void backtrack(int n, int k, int start, ArrayList<Integer> ans) {
        if (ans.size()==k){
            list.add(new ArrayList<>(ans));
            return;
        }
//        使用剪枝优化，将i<=n 改为i<= n-(k-ans.size)+1
//        for (int i = start; i <= n; i++) {
        for (int i = start; i <= n-(k-ans.size())+1; i++) {
            ans.add(i);
            backtrack(n,k,i+1,ans);
            ans.remove(ans.size()-1);
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
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
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
        if (nums.length==0) return result;
        int len = nums.length;
        for (int i = 0; i < Math.pow(2, len); i++) {
            String tmp = Integer.toBinaryString(i);
            List<Integer> list = new LinkedList<>();
//            String ans = "";
            for (int j = 0; j < tmp.length(); j++) {
                if (tmp.charAt(tmp.length()-1-j)=='1') list.add(nums[j]);
            }
            result.add(list);
        }
        return result;
    }
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack1(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack1(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack1(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
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
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }
    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
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

    public static void main(String[] args){
        int i=0;
        String tmp = Integer.toBinaryString(i);
        System.out.println(tmp.length());
        String tmp2 = Integer.toBinaryString(7);
        System.out.println(tmp2.length());
        int[] nums = new int[]{1,2,3};
        Backpacking bp = new Backpacking();
        List<List<Integer>> result=bp.subsets(nums);
    }
}
