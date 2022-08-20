package com.leetcode.dynamicprogramming.splittypequestions;

import java.util.Arrays;

public class PerfectSquares {

    /*
    * https://leetcode.com/problems/perfect-squares
    *
    * 思路：
    *   1. dp用来保存每一个数字的最小平方数
    *   2. dp的index是参与运算的值
    *   3. 每个整数，最大的n实际上就是它本身（n个1的累加），所以默认初始化Max_value
    *   4. dp[i] 会被多次赋值，第一次赋值（j==1）时，dp[i] == i，也是它能取的最大值（见第3条）
    *   5. dp[i - j*j]+1: 表示当 j*j > 1 且 j*j < i 时，相当于i减掉j*j后，余数的最小平方数是多少（+1表示要把这次的j*j算上）
    * */
    public static void main(String[] args) {

        int n = 13;
        System.out.println(new PerfectSquares().numSquares(n));
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
