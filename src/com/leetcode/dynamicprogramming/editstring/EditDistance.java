package com.leetcode.dynamicprogramming.editstring;

public class EditDistance {

    /*
    * https://leetcode.com/problems/edit-distance/
    *       我们使用一个二维数组 dp[i][j]，表示将第一个字符串到位置 i 为止，和第
    * 二个字符串到位置 j 为止，最多需要几步编辑。当第 i 位和第 j 位对应的字符相同时，
    * dp[i][j] 等于 dp[i-1][j-1]；当二者对应的字符不同时，修改的消耗是 dp[i-1][j-1]+1，
    * 插入 i 位置/删除 j 位置的消耗是 dp[i][j-1] + 1，插入 j 位置/删除 i 位置的消耗是
    * dp[i-1][j] + 1。
    *
    *
    * */
    public static void main(String[] args) {
        String word1 = "intention", word2 = "execution";
        System.out.println(new EditDistance().minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = dp[0][i-1] + 1;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                char cur1 = word1.charAt(i-1);
                char cur2 = word2.charAt(j-1);
                if (cur1 == cur2) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                }
            }
        }

        return dp[n1][n2];
    }
}
