package com.leetcode.primary;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Jay
 * @Date: Created in 19:02 2018/5/29
 * @Modified By:
 */
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                char now = board[i][j];
                if (now == '.') continue;
                else {
                    if (set.contains(now)) {
                        return false;
                    } else {
                        set.add(now);
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Set set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                char now = board[j][i];
                if (now == '.') continue;
                else {
                    if (set.contains(now)) {
                        return false;
                    } else {
                        set.add(now);
                    }
                }
            }
        }
        for (int i = 0; i < 9; i = i + 3) {
            for (int k = 0; k < 9; k = k + 3) {
                Set set = new HashSet<Character>();
                for (int j = i; j < 3 + i; j++) {
                    for (int l = k; l < 3 + k; l++) {
                        char now = board[j][l];
                        if (now == '.') continue;
                        else {
                            if (set.contains(now)) {
                                return false;
                            } else {
                                set.add(now);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
