package com.leetcode.sorts;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertionSort (int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    private static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
