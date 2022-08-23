package com.leetcode.String.compare;

public class PalindromicSubstrings {

    /*
    * https://leetcode.com/problems/palindromic-substrings/
    *
    * 思路：
    *   1. 每个字符都要单独计数
    *   2. 从每个字符向两边扩，看是否相等
    *   3. 分奇数偶数进行查找计数
    * */
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += extendSubstring(s, i, i);
            count += extendSubstring(s, i, i+1);
        }
        return count;
    }

    public static int extendSubstring(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
            ++count;
        }
        return count;
    }
}
