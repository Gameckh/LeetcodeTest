package com.leetcode.dynamicprogramming.onedimension;

public class MinCostClimbingStairs {
    public static void main(String[] args) {

//        int[] cost = {10,15,20};
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(new MinCostClimbingStairs().mySolution(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int prevOne = cost[1];
        int prevTwo = cost[0];
        int curr = 0;

        for (int i = 2; i < cost.length; i++) {
            curr = Math.min(prevTwo, prevOne) + cost[i];
            prevTwo = prevOne;
            prevOne = curr;
        }

        return curr;
    }

    public int mySolution(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < n; i++){
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}
