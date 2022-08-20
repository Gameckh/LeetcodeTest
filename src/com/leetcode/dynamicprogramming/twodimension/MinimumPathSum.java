package com.leetcode.dynamicprogramming.twodimension;

import java.util.Arrays;

public class MinimumPathSum {

    public static void main(String[] args) {

        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
        System.out.println(myMinPathSum(grid));
    }

    /*
    * 思路：
    *   只能向下、右两个方向，就遍历所有格子，然后当出现分叉时，找小的那个就行了
    *   一句话思路：每一步都选较小的，最后就是最小的
    *   dp矩阵：
    *       dp矩阵就是保存不同路径下最小可能性的矩阵
    *       dp矩阵的每个格子只跟左、上两个格子相关
    *       空间压缩：对于第 i 行，在遍历到第 j 列的时候，因为第 j-1 列已经更新过了，所以 dp[j-1] 代表 dp[i][j-1]
的值；而 dp[j] 待更新，当前存储的值是在第 i-1 行的时候计算的，所以代表 dp[i-1][j] 的值。
    *   循环中的判断：
    *       起点（左上角，0,0）：直接赋值即可，没有可以累加的
    *       第一行(i==0)：一层循环后续还要往下走，所以dp[0][j]的可能性就一种：dp[0][j-1] + grid[0][j]
    *       第一列(j==0)：同理，在列方向上，只有dp[i-1][0] + grid[i][0]
    *       最后：选择行、列上较小的值与grid[i][j]累加
    * */
    public static int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[] dp = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else if (i == 0) {
                    dp[j] = dp[j-1] + grid[i][j];
                } else if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[col-1];
    }

    public static int myMinPathSum(int[][] grid){
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0]  + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1]  + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }

}
