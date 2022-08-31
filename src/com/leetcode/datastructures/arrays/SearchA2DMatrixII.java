package com.leetcode.datastructures.arrays;

public class SearchA2DMatrixII {

    /*
    * https://leetcode.com/problems/search-a-2d-matrix-ii/
    *
    * 思路：
    *   1. 看到有序数组，就想起二分法，二维数组就想起了对角线二分，就想起了右上-左下对角线
    *   2. 但这道题有个小技巧，从右上开始找，左边比target大，向左移动，左边比target小，向下移动
    *   3. 如果找到右下角都没找到，就无解
    *
    * */
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int target = 5;
        target = 20;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int r = 0, c = cols-1;
        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) return true;
            if (matrix[r][c] > target) c--;
            else r++;
        }
        return false;
    }
}
