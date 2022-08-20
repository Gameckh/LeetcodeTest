package com.leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    /**
     * https://leetcode.com/problems/n-queens/
     *
     * 思路：
     *  1. 顺序：按列 -> 行，查找每一种可能性，要求每一行都能放下1个Q
     *  2. 回溯法：设置完Q后，进入深一层递归，从Q出发继续判断能否满足条件，最后跳出递归时要改回'.'
     *  3. 判断：当查到Q后，判断行、列、对角线是否有其它Q
     *      行：x == i
     *      列：判断中不可能出现 y == j 的情况，不用判断
     *      对角线：
     *          1) 当对角线方向是：/ 时，判断 行 + 列 索引相等即可
     *          2) 当对角线方向是：\ 时，换个元素（行或列都行），变成/，再判断 行 + 列 相等
     * */
    public static void main(String[] args) {

        int n = 4;
        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, result, 0);
        return result;
    }

    public static void dfs(char[][] board, List<List<String>> result, int colIndex) {
        if (colIndex == board.length) {
            result.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, result, colIndex + 1);
                board[i][colIndex] = '.';
            }
        }
    }

    public static boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x == i || x + j == y + i || x + y == i + j))
                    return false;
            }
        }
        return true;
    }

    public static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }

}
