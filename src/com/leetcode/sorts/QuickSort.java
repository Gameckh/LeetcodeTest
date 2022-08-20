package com.leetcode.sorts;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        int[] nums1 = {8,6,2,3,1,5,7,4};
        quickSort(nums1);
        System.out.println(Arrays.toString(nums1));
    }


    public static void quickSort (int[] nums) {

        sort(nums, 0, nums.length - 1);
    }

    public static void sort (int[] nums, int left, int right) {

        if (left >= right) return;

        int pivot = partition(nums, left, right);
        // 递归，从分界点开始，把前后两个数组继续执行partition操作
        // 注意，这里pivot位置的值是已经排好序的，所以要避开（left ~ p-1， p+1 ~ right）
        sort(nums, left, pivot - 1);
        sort(nums, pivot + 1, right);
    }

    public static int partition (int[] nums, int l, int r) {

        int value = nums[l];
        int j = l;
        // arr[l+1...j] < v ; arr[j+1...i) > v
        // 初始状态下，小于v部分的数组是空，大于v部分数组也是空，两边都满足需求
        for (int i = l + 1; i <= r; i++) {
            // 当nums[i] > value时，让i继续++即可
            // 反之，让j指针右移(l+1)，把这个比value小的值换到前边j的位置上来
            if (nums[i] < value) {
                j++;
                swap(nums, i, j);
            }
        }

        // 最后把value换到j的位置上，j本来位置上的值是小于value的，所以正确
        swap(nums, l, j);
        return j;
    }

    private static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
