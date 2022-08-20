package com.leetcode.dynamicprogramming.twodimension;

import java.util.Arrays;

public class Matrix_01 {

    /*
    * https://leetcode.com/problems/01-matrix/
    *
    *   思路：因为这道题涉及到四个方向上的最近搜索，所以很多人的第一反应可能会是广度优先搜索。
    * 但是对于一个大小 O(mn) 的二维数组，对每个位置进行四向搜索，最坏情况的时间复杂度（即全是 1）
    * 会达到恐怖的 O(m2n2)。
    *   两个dp的思路：
    *   1) 用dp矩阵做memorization, 让广度优先搜索不会找重复的元素
    *   2) 分别从左上、右下两个方向，用dp各来一次动态搜索即可
    *
    *   解法注释：
    *   0) 用dp矩阵记录各个点与0的最小距离
    *   1) 初始化dp时，默认填充值要设置MAX_VALUE-1(-1是为了防止溢出)，避免影响后续的逻辑计算（路径有可能比2大）
    *   2) 第一次循环，需要判断起始值，如果是0，一定要先给dp赋值0，否则默认值会影响后续计算
    *   3) 第一次循环，遇到matrix中元素为1时
    *       a. 因为i > 0 和 j > 0 交替执行，所以需要判断当前位置与前一个位置 +1 的大小
    *       b.
    *   4) 第二次循环，反向来一遍就行，注意结束条件一定要>=0，查左、上方向的距离，取较小值。
    * */
    public static void main(String[] args) {
        // [[0,1,0,1,1],[1,1,0,0,1],[0,0,0,1,0],[1,0,1,1,1],[1,0,0,0,1]]
        int[][] matrix = {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
//        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        // [[0,1,0,1,2],[1,1,0,0,1],[0,0,0,1,0],[1,0,1,1,1],[1,0,0,0,1]]
        System.out.println(Arrays.deepToString(new Matrix_01().updateMatrix(matrix)));
    }

    public int[][] updateMatrix(int[][] mat) {
        int width = mat.length, height = mat[0].length;
        int[][] dp = new int[width][height];
        for (int i = 0; i < width; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE-1);
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                    }
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
                    }
                }
            }
        }
        for (int i = width - 1; i >= 0; i--) {
            for (int j = height - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    if (i < width - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
                    }
                    if (j < height - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
                    }
                }
            }
        }
        return dp;
    }
}
