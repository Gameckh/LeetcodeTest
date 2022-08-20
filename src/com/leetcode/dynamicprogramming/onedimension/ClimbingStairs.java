package com.leetcode.dynamicprogramming.onedimension;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {

        int n = 3;
        System.out.println(climbStairs2(n));
    }

    public static int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairs2(int n) {
        if (n <= 2) return n;
        int pre2 = 1, pre1 = 2, cur = 0;
        for (int i = 2; i < n; i++) {
            cur = pre2 + pre1;
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}
