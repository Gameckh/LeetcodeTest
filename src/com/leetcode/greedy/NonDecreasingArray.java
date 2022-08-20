package com.leetcode.greedy;

import java.util.Arrays;

public class NonDecreasingArray {

    public static void main(String[] args) {

        int[] nums = {3,4,2,3};     // false
        int[] nums1 = {5,7,1,8};    // true
        int[] nums2 = {4,2,1};      // false
        int[] nums3 = {4,2,3};      // true
        System.out.println(checkPossibility(nums));
        System.out.println(checkPossibility(nums1));
        System.out.println(checkPossibility(nums2));
        System.out.println(checkPossibility(nums3));
    }

    public static boolean checkPossibility(int[] nums) {

        int size = nums.length;
        int modifyCount = 0;
        for (int i = 1; i < size && modifyCount <= 1; i++) {
            if (nums[i] < nums[i-1]) {
                modifyCount ++;
                if ((i-2) < 0 || nums[i-2] <= nums[i]) {
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
            }
        }
        return modifyCount <= 1;
    }
}
