package com.leetcode.binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {5,7,7,8,8,10};
        int[] nums2 = {1,2,3,4,9,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums1, target)));
        System.out.println(Arrays.toString(searchRange(nums2, target)));
    }

    public static int[] searchRange(int[] nums, int target) {

        int[] result = new int[]{-1, -1};

        int lower = lowerBound(nums, target);
        int upper = upperBound(nums, target) - 1;

        // 当 l 返回值等于nums.length时说明没找到
        // 否则判断是否等于target
        if (lower == nums.length || nums[lower] != target) {
            return result;
        }
        result[0] = lower;
        result[1] = upper;
        return result;
    }

    // lower_bound: 在指定范围内查找不小于目标值的第一个元素
    private static int lowerBound (int[] nums, int target) {
        int l = 0, r = nums.length, mid = 0;

        // l不能等于r，按循环逻辑，l==r时，mid==r，这样形成死循环
        while (l < r) {
            mid = (l + r) / 2;
            // 与upper_bound的区别：>=
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    // upper_bound: 在指定范围内查找大于目标值的第一个元素
    private static int upperBound (int[] nums, int target) {

        int l = 0, r = nums.length, mid = 0;

        while (l < r) {
            mid = (l + r) / 2;
            // 与lower_bound的区别：>
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
