package com.leetcode.binarysearch;

public class FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int min = nums[0];

        int start = 0, end = nums.length - 1, mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (min > nums[mid]) {
                min = nums[mid];
            }
            // 判断前后哪边是有序的(同样需要考虑所有元素相同的情形)
            if (nums[start] == nums[mid]) {
                start ++;
            } else if (nums[mid] <= nums[end]) {
                // 后半段有序，从前半端查
                end = mid - 1;
            } else {
                // 前半段有序，从后半段查
                start = mid + 1;
            }
        }

        return min;
    }
}
