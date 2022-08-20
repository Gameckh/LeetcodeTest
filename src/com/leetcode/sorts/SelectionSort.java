package com.leetcode.sorts;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectionSort (int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
