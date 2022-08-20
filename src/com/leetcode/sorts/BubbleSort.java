package com.leetcode.sorts;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort (int[] nums) {

        boolean isSwapped;
        int len = nums.length;
        // 外层循环不做排序标记，每迭代一次，就有一个最大数被排到最后，内层循环的次数少一次
        for (int i = 1; i < len; i++) {
            isSwapped = false;
            // 排序在内层循环做，起点为1，终点就是总长度减去排序次数（已排好序的元素个数）
            for (int j = 1; j < len - i + 1; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    private static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
