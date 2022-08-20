package com.leetcode.dynamicprogramming.onedimension;

public class HouseRobber {
    public static void main(String[] args) {

        int[] nums = {2,7,9,3,1};
        System.out.println(rob2(nums));

    }

    // dp[i] = max(dp[i - 1], nums[i-1] + dp[i-2])
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i-1] + dp[i-2]);
        }
        return dp[nums.length];
    }

    public static int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        int pre2 = 0, pre1 = 0;
        int cur = 0;
        for (int num : nums) {
            cur = Math.max(pre1, num + pre2);
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}
