package com.leetcode.dynamicprogramming.onedimension;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DeleteAndEarn {
    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4};
        int[] nums2 = {3,4,2};
        int[] nums3 = {3,1};
        int res = new DeleteAndEarn().deleteAndEarn(nums);
        System.out.println(res);
    }

    public int deleteAndEarn(int[] nums) {
        int n = 10002;
        int[] sum = new int[n];
        for (int i = 0; i < nums.length; i++) {
            sum[nums[i]] += nums[i];
        }
        for (int i = 2; i < n; i++) {
            sum[i] = Math.max(sum[i-1], sum[i-2] + sum[i]);
        }
        return sum[n-1];
    }
}
