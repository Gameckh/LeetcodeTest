package com.leetcode.dynamicprogramming.twodimension;

public class MaximalSquare {

    /*
    * Not trying to be a smart ass but I did in few minutes.
    * Once you solve few DP problems with matrix the first intuition is to scan table line by line
    * and the only question is how to build the dp[row][col] if you already have dp table for any lower index.
    * To figure it out, just go on paper with one or two small tables (like the example one) and you come up quickly with the formula for building dp[][] table.
    * Then the implementation is trivial.
    * */
    public static void main(String[] args) {

    }

    public int maximalSquare(char[][] matrix) {
        int width = matrix.length, height = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[width+1][height+1];
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }
}
