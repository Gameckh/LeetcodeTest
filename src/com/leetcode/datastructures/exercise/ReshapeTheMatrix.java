package com.leetcode.datastructures.exercise;

import java.util.Arrays;

public class ReshapeTheMatrix {

    /*
    * https://leetcode.com/problems/reshape-the-matrix/
    *
    * 思路：
    *  注意换行时，值不要丢
    * */

    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4}};
        int r = 4, c = 1;
        System.out.println(Arrays.deepToString(matrixReshape(mat, r, c)));
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (r * c != m * n) return mat;
        int[][] res = new int[r][c];
        int rIndex = 0, cIndex = 0;
        for (int[] row : mat) {
            for (int val : row) {
                if (rIndex < r) {
                    if (cIndex < c) {
                        res[rIndex][cIndex++] = val;
                    } else {
                        rIndex ++;
                        res[rIndex][0] = val;
                        cIndex = 1;
                    }
                }
            }
        }
        return res;
    }
}
