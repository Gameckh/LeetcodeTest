package com.training.search.backtracking;

import java.util.LinkedList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {

    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtracking(res, board, 0);
        return res;
    }

    private static void backtracking(List<List<String>> res, char[][] board, int colIndex) {
        if (colIndex == board.length) {
            res.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                backtracking(res, board, colIndex + 1);
                board[i][colIndex] = '.';
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> list = new LinkedList<>();
        for (char[] chars : board) {
            String str = new String(chars);
            list.add(str);
        }
        return list;
    }

    private static boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x == i || x + j == y + i || x + y == i + j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
