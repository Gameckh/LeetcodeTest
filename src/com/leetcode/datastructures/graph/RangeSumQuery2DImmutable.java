package com.leetcode.datastructures.graph;

public class RangeSumQuery2DImmutable {

    /*
    * https://leetcode.com/problems/range-sum-query-2d-immutable/
    *
    * 思路：
    * 1. 和一维前缀图思路类似，声明一个矩阵来存储累加结果，从而让取值计算时间复杂度达到O(1)级别
    * 2. 两个重要公式：
    *   <1> 累加公式：E = D + C + B - A;
    *   <2> 求值公式：E = D - C - B + A;
    *   公式是怎么来的，可以参考文章图例。
    * */
    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}});
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (i.e sum of the red rectangle)
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (i.e sum of the green rectangle)
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (i.e sum of the blue rectangle)
    }
}

class NumMatrix {

    int[][] integral;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        integral = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 矩阵积分公式：E = D + C + B - A;
                integral[i][j] = matrix[i-1][j-1] + integral[i][j-1] +
                        integral[i-1][j] - integral[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 求和公式：E = D - B - C + A;
        return integral[row2+1][col2+1] - integral[row2+1][col1] -
                integral[row1][col2+1] + integral[row1][col1];
    }
}
