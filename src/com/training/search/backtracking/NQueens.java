package com.training.search.backtracking;

import java.util.LinkedList;
import java.util.List;

public class NQueens {

    /*
    * https://leetcode.com/problems/n-queens/description/
    * */
    public static void main(String[] args) {

    }

    /*
    * Problem solution:
    * 1. At first, we need a chess board and a result list, and we use backtracking to fill them.
    * 2. In the backtracking function, we fill queens from left to right:
    *       <1> Need a position pointer, to save the column index which the current is.
    *       <2> If the position pointer equals with the board's length, means we finished one solution.
    * 3. Declare a function to validate whether the current cell can put a queen or not.
    *       <1> Row -- from 0 to the end of the chess board;
    *       <2> Column -- from 0 to the position index;
    *       <3> If found a Queen, then check four directions:
    *           a). x == i: means the Queen is in the same row with current cell, then false.
    *           b). y == j: means the Queen is in the same column with current cell, then false.
    *           c). x + j == y + i: means the Queen is in the diagonal from left top to right bottom, then false.
    *           d). x + y == i + j: means the Queen is in the diagonal from right top to left bottom, then false.
    * */
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
