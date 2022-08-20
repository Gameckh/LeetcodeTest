package com.leetcode.sorts;

import java.util.Arrays;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {

        int[] nums = {3,2,1,5,6,4};
        int k = 2; // output: 5

//        int mid = quickSelection(nums, 0, nums.length - 1);
//        System.out.println(mid);
//        System.out.println(Arrays.toString(nums));

        int[] nums1 = {3,2,3,1,2,4,5,5,6};
        int k1 = 4; // output: 4

        // 特殊情况：findKthLargest需要返回数组中的元素
        int[] nums2 = {1};
        int k2 = 1;

//        int mid1 = quickSelection(nums1, 0, nums1.length - 1);
//        System.out.println(mid1);
//        System.out.println(Arrays.toString(nums1));

//        System.out.println(findKthLargest(nums, k));
//        System.out.println(findKthLargest(nums1, k1));
        System.out.println(findKthLargest(nums2, k2));
    }

    public static int findKthLargest(int[] nums, int k) {

        int l = 0, r = nums.length - 1, target = nums.length - k;

        while (l < r) {
            int pivot = quickSelection(nums, l, r);
            if (pivot == target) return nums[pivot];
            // 如果没找到正确的pivot，按大小分开找
            if (pivot > target) {
                // pivot比target大，说明目标在pivot左边数组中
                r = pivot - 1;
            } else {
                // 反之，在右边数组
                l = pivot + 1;
            }
        }

        // 特殊情况，当数组只有1个元素时
        return nums[l];
    }

    public static int quickSelection(int[] nums, int l, int r) {

        int i = l + 1, j = r;
        while (true) {
            // nums[l] 就是这个选定的pivot的元素，接下来需要确定它的位置，就是pivot的值
            while (i < r && nums[i] <= nums[l]) {
                i ++;
            }
            while (j > l && nums[j] >= nums[l]) {
                j --;
            }
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }


    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}
