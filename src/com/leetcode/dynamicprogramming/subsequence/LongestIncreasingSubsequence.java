package com.leetcode.dynamicprogramming.subsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums1 = {0,1,0,3,2,3};
        int[] nums2 = {7,7,7,7,7,7,7};
        int[] nums3 = {4,10,4,3,8,9};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums3));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= n; i++) {
            if (nums[i-1] > nums[i-2]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = dp[i-1];
            }
        }

        return dp[n];
    }
}
