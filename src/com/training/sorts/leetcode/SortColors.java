package com.training.sorts.leetcode;

import java.util.Arrays;

public class SortColors {

    /*
    * https://leetcode.com/problems/sort-colors/description/
    * */
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
    * Quick sort in 3 ways:
    *
    * This is a typical problem for Quick-sort 3 ways.
    * The Quick-sort 3 ways can be used to sort the array which has lots of repeated elements.
    * 1. Quick-sort 3 ways splits the array in 3 partitions, less than pivot | equals pivot | more than pivot.
    * 2. Set 3 pointers which are lt(less than) gt(greater than) and i.
    *
    * Explanation: imooc lesson
    * https://coding.imooc.com/lesson/71.html#mid=1461
    * */
    public static void sortColors(int[] nums) {
        int lt = 0, gt = nums.length - 1;
        int pivot = 1;
        for (int i = lt; i <= gt; i++) {
            if (nums[i] < pivot) {
                swap(nums, lt++, i);
            } else if (nums[i] > pivot) {
                swap(nums, i--, gt--);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
