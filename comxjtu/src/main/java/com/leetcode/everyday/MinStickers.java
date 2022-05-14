package com.leetcode.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/14 20:15
 * @description //691:这个解答实现错了，将重复选用的记为一次了；如果不记为一次，则使用map数组来做、
 */
public class MinStickers {
    public int minStickers(String[] stickers, String target) {
        Set<Character>[] stickerSetArray = new HashSet[stickers.length];
        for (int i = 0; i < stickers.length; i++) {
            stickerSetArray[i] = generateSet(stickers[i]);
        }
        Set<Character> targetSet = generateSet(target);
        int ans = -1;
        ans = backtrack(stickerSetArray, targetSet, 0, Integer.MAX_VALUE);
        return ans==Integer.MAX_VALUE ? -1: ans;
    }

    private int backtrack(Set<Character>[] stickerSetArray, Set<Character> targetSet, int start, int min) {
        if (0 == targetSet.size()){
            return start;
        }
        if (start == stickerSetArray.length) return Integer.MAX_VALUE;

        for (int i = start; i < stickerSetArray.length; i++) {
            Set<Character> targetSetOri = new HashSet<>(targetSet);
            int matchCount = intersection(stickerSetArray[i], targetSet);
            if (matchCount!=0){
                int count = backtrack(stickerSetArray, targetSet, i+1, min);
                min = count<min ? count : min;
            }
            targetSet = targetSetOri;
        }
        return min;
    }

    private int intersection(Set<Character> characters, Set<Character> targetSet) {
        int count = 0;
        for (Character ch :
                characters) {
            if (targetSet.contains(ch)){
                targetSet.remove(ch);
                count++;
            }
        }
        return count;
    }

    private Set generateSet(String sticker) {
        Set<Character> stickerSet = new HashSet();
        for (int i = 0; i < sticker.length(); i++) {
            stickerSet.add(sticker.charAt(i));
        }
        return stickerSet;
    }

    public static void main(String[] args) {
        MinStickers minStickers = new MinStickers();
        Set<Character> stickerSet = minStickers.generateSet("starta");
        Set<Character> targetSetOri = new HashSet<>(stickerSet);
        targetSetOri.remove('s');
        for (Character sticker:
                stickerSet) {
            System.out.print(sticker);
        }
        System.out.println();
        for (Character sticker:
                targetSetOri) {
            System.out.print(sticker);
        }
        System.out.println();
        int matchCount = minStickers.intersection(stickerSet, targetSetOri);
        System.out.println(matchCount);
        for (Character sticker:
                targetSetOri) {
            System.out.print(sticker);
        }
        System.out.println(minStickers.minStickers(new String[]{"with","example","science"}, "thehat"));
    }
}
