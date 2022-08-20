package com.leetcode.dynamicprogramming.onedimension;

import java.util.Arrays;

public class ArithmeticSlices {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    // 思路：等差数列的排列个数，根据等差数列长度，还是个斐波那契数列
    // 例：1234，有3个子数组，12345，有6个子数组
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = dp[i-1] + 1;
            }
        }
        return Arrays.stream(dp).sum();
    }
}
