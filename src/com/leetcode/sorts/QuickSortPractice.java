package com.leetcode.sorts;

import java.util.Arrays;

public class QuickSortPractice {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        int[] nums1 = {8,6,2,3,1,5,7,4};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort (int[] nums) {

        if (nums.length < 2) return;

        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int left, int right) {

        if (left >= right) return;

        int pivot = partition(nums, left, right);
        sort(nums, left, pivot - 1);
        sort(nums, pivot + 1, right);
    }

    public static int partition(int[] nums, int l, int r) {

        int v = nums[l];
        int p = l;

        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < v)
                swap(nums, ++p, i);
        }
        swap(nums, l, p);

        return p;
    }

    public static void swap (int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
