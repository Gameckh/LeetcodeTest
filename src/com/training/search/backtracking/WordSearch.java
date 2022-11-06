package com.training.search.backtracking;

public class WordSearch {

    /*
    * https://leetcode.com/problems/word-search/
    * */
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    /*
    * Typical framework for the backtracking problems:
    * 1. we need an m*n matrix to save the check result, and when the recursion is getting out
    *       of the stacks, we should roll back the value of the boolean matrix.
    * 2. Backtracking function need a parameter POSITION to mark which character we are finding
    *       in the recursion. Obviously it starts from 0.
    * 3. Three IF condition statements:
    *       Return for jump out of the recursion when the row & col indexes are out of the bounds.
    *       Return for jump out of the recursion when the program already found the result, or checked current cell, or checking the wrong cell.
    *       Return for jump out of the recursion when this cell is the last cell we are finding for, then isFound[0] = true.
    * 4. Continue to find next correct cell from four directions.
    *       Notice that checked matrix must be "back track" when the backtracking done, because:
    *           If current direction failed to find the result, certainly we need to roll back the checked status.
    *           If current direction succeed to find the result, checked status is not important anymore.
    * */
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] checked = new boolean[m][n];
        boolean[] isFound = new boolean[1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtracking(board, checked, isFound, word, i, j, 0);
            }
        }

        return isFound[0];
    }

    private static final int[] directions = {-1, 0, 1, 0, -1};
    private static void backtracking(char[][] board, boolean[][] checked, boolean[] isFound, String word, int row, int col, int position) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        if (checked[row][col] || isFound[0] || word.charAt(position) != board[row][col]) return;
        if (position == word.length() - 1) {
            isFound[0] = true;
            return;
        }

        // Prevent duplicate search, such as finish the right search and return the left cell.
        checked[row][col] = true;
        for (int i = 0; i < directions.length - 1; i++) {
            backtracking(board, checked, isFound, word, row + directions[i], col + directions[i+1], position + 1);
        }
        // Prevent influence other directions search.
        checked[row][col] = false;
    }
}
