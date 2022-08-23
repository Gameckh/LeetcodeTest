package com.leetcode.String.compare;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    /*
    * https://leetcode.com/problems/longest-palindrome/
    *
    * 思路：
    *   既然给定的s中字符可以随意改变顺序，那么这道题本质上就是寻找回文字符串的字符特点
    *   1. 当s长度为偶数(even)时，所有字符都为偶数个数
    *   2. 当s长度为奇数(odd)时，1个字符为奇数，其它字符均为偶数
    *   3. 计算回文长度时，遇到偶数+count，遇到奇数+(count-1)，减去1个奇数字符
    *   题目的测试用例中包含大小写，但实际上不用区分大小写。
    * */
    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            int count = map.getOrDefault(cur, 0);
            map.put(cur, count + 1);
        }

        int maxLen = 0;
        boolean isOdd = false;
        for (Character c: map.keySet()) {
            int count = map.get(c);
            if (count % 2 != 0) {
                maxLen += count-1;
                isOdd = true;
            } else {
                maxLen += count;
            }
        }
        return maxLen + (isOdd ? 1 : 0);
    }
}
