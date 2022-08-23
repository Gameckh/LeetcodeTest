package com.leetcode.String.compare;

public class CountBinarySubstrings {

    /*
    * https://leetcode.com/problems/count-binary-substrings/
    *
    * 思路：
    *   这道题重在找规律:
    *   1. 如果连续的字符是相等的，例如00或111，不存在结果
    *   2. 如果遇到某个字符，跟之前连续字符不同，则开始计数，比如00001，从1开始计数
    *
    *   那么实现方法如下：
    *   1. 用cur记录连续相同字符的数量，例如在00011中，cur从1开始（当前字符），数到3，都是0
    *   2. 用pre记录之前连续相同字符的数量，pre就是上一个cur的值，cur重新从1开始计数
    *   3. 判断pre是否大于等于cur，如果pre大于等于cur，例如00011，那么可以一直++count
    * */
    public static void main(String[] args) {
        String s = "00001";
        System.out.println(countBinarySubstrings(s));
    }

    public static int countBinarySubstrings(String s) {
        if (s.length() == 1) return 0;
        // cur是和当前数字相同，且连续的长度
        // pre是和之前连续的不同数字的长度
        int pre = 0, cur = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                count++;
            }
        }
        return count;
    }
}
