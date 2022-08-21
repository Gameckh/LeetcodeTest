package com.leetcode.String.reverse;

public class ReverseStringII {

    /*
    *
    * https://leetcode.com/problems/reverse-string-ii/
    *   Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
    *   If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters,
    * then reverse the first k characters and leave the other as original.
    *
    * */
    public static void main(String[] args) {
        String s = "ab";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        recursion(chars, 0, k);
        return new String(chars);
    }

    public static void recursion(char[] chars, int from, int k) {
        int len = chars.length;
        if (from >= len) return;
        if (from + k >= len) {
            reverse(chars, from, len - 1);
            return;
        }
        reverse(chars, from, from + k - 1);
        if (from + k*2 >= len) return;
        recursion(chars, from + 2*k, k);
    }

    public static void reverse(char[] chars, int from, int to) {
        while (from < to) {
            char c = chars[from];
            chars[from++] = chars[to];
            chars[to--] = c;
        }
    }
}
