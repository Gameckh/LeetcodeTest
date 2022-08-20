package com.leetcode.dynamicprogramming.splittypequestions;

import java.util.Arrays;

public class DecodeWays {

    /*
    *
    * https://leetcode.com/problems/decode-ways/
    *
    * 思路：
    *   1. 1~26之间的不含0数字，1位数都有1个字母对应，两位数都有2个字母对应
    *   2. 遇到10、20，只有1个字母对应
    *   3. 遇到0开头的，不存在，直接过
    *   4. 遇到大于26的，拆开，只能单位表示
    *   5. 不可能出现的情况：00、30这类数字是完全没办法转换的，直接return
    *   6. 两个判断：
    *       1) 如果prev是0或3，那么前一位算出来的可能性dp[i-1]就是当前位的可能性
    *       2) 如果prev是1或2，并且cur==0，那prev和cur必须放在一起算，且只有1种可能性，不会影响到可能性数量，所以就等于dp[i-2]，例如：1120可能性 == 11的可能性
    * */
    public static void main(String[] args) {

        String s = "2101";
        System.out.println(new DecodeWays().myNumDecode(s));
    }

    public int myNumDecode(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int prev = s.charAt(0) - '0';
        if (prev == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            int cur = s.charAt(i-1) - '0';
            if ((prev == 0 || prev > 2) && cur == 0) {
                return 0;
            }
            if (prev == 1 || prev == 2 && cur < 7) {
                if (cur == 0) {
                    dp[i] = dp[i-2];
                } else {
                    dp[i] = dp[i-1] + dp[i-2];
                }
            } else {
                dp[i] = dp[i-1];
            }
            prev = cur;
        }
        return dp[n];
    }


    public int numDecodings(String s) {

        int n = s.length();
        if (n == 0) return 0;
        int prev = s.charAt(0) - '0';
        if (prev == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            int cur = s.charAt(i-1) - '0';
            // 不可能出现的情况：00、30这类数字是完全没办法转换的，直接return
            if ((prev == 0 || prev > 2) && cur == 0) {
                return 0;
            }
            // 前一位是1或2，cur小于7时，分两种情况
            if (prev == 1 || prev == 2 && cur < 7) {
                // cur 在 1~6，两种decode法
                if (cur > 0) {
                    dp[i] = dp[i-1] + dp[i-2];
                } else { // cur是0或7，只有一种decode法
                    dp[i] = dp[i-2];
                }
            } else {
                // 前一位0，或超出26，只有一种decode法
                dp[i] = dp[i-1];
            }
            prev = cur;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
