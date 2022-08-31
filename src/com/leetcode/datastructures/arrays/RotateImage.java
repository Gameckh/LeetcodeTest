package com.leetcode.datastructures.arrays;

import java.util.Arrays;

public class RotateImage {

    /*
    * https://leetcode.com/problems/rotate-image/
    *
    * 思路：
    * 1. 先按行列转置的逻辑，matrix[row][col] = matrix[col][row];
    * 2. 再把每一个数组reverse
    * */
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix1 = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

//        int[] test = {1,2,3,4};
//        reverse(test);
//        System.out.println(Arrays.toString(test));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) swap(matrix, i, j);
            }
        }
        for (int[] nums : matrix) {
            reverse(nums);
        }
    }

    public static void swap (int[][] matrix, int r, int c) {
        int temp = matrix[r][c];
        matrix[r][c] = matrix[c][r];
        matrix[c][r] = temp;
    }

    public static void reverse(int[] nums){
        int n = nums.length;
        int h = n/2;
        for (int i = 0; i < h; i++) {
            int temp = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = temp;
        }
    }
}
