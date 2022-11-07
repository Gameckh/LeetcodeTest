package com.training.search.depthfirst;

import java.util.Arrays;

public class SurroundedRegions {

    /*
    * https://leetcode.com/problems/surrounded-regions/description/
    * */
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    /*
    * Problem Comprehension:
    * I misunderstood this problem in the beginning.
    * This question's real intention is to find the adjacent 'O's FROM THE BORDER!
    * The 'O' which is not adjacent with the border (the regions surrounded by 'X' in 4-direction) should be flipped to 'X'.
    * Then the solution is sample now:
    * 1. We find all 'O' starts with 4 borders and don't care about the inner 'O's.
    * 2. Use another character to mark the 'O' which adjacent with the border.
    * 3. Then traverse all the matrix to flip 'O' to 'X', and recover the 'O'.
    * */
    public static void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }

        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static int[] directions = {-1, 0, 1, 0, -1};
    private static void dfs(char[][] board, int m, int n){
        if (m < 0 || n < 0 || m >= board.length || n >= board[0].length)
            return;
        if (board[m][n] == 'X' || board[m][n] == '*')
            return;
        board[m][n] = '*';
        for (int i = 0; i < directions.length - 1; i++) {
            dfs(board, m + directions[i], n + directions[i+1]);
        }
    }
}
