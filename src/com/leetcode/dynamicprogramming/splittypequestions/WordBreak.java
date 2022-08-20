package com.leetcode.dynamicprogramming.splittypequestions;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    /**
     * 没完全理解题意
     * */
    /*
    * https://leetcode.com/problems/word-break/
    *
    * 理解：
    *   1. wordDict无重复元素
    *   2. s是split后与wordDict进行匹配，也就是说顺序不变
    *   3. s切分的片段，必须都能在wordDict中找到，例如“applepeneee” ["apple","pen"] 就false
    *   4. s切分的片段，必须能够全包含wordDict的单词，例如下边这个case就false：
    *           s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    *
    * 思路：类似完全平方数
    *   1. 有了以上对题目的理解，不难分析出，只要判断每个片段都能对得上wordDict中的单词即可
    *   2. 如果有字母被两个单词共享，false
    *   3. dp的下标可以理解是切分点，某个切分点能否满足题设，结论就是dp[i]的值
    *   3. dp[0] = true，表示s的第一个片段不需要考虑前边的片段共享问题
    *   4. dp[i] = dp[i] || dp[i-len] 表示
    * */
    public static void main(String[] args) {

//         String s = "applepenapple";
//         List<String> wordDict = Arrays.asList("apple","pen");

        // s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");


        String s = "dogs";
        List<String> wordDict = Arrays.asList("dog","s","gs");

        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && s.substring(i-len, i).equals(word)) {
//                    dp[i] = dp[i] || dp[i-len];
                    dp[i] = dp[i] || dp[i-len];
                }
            }
        }
        return dp[n];
    }
}
