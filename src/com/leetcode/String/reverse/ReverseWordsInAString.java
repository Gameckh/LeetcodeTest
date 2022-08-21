package com.leetcode.String.reverse;

public class ReverseWordsInAString {


    /*
    * https://leetcode.com/problems/reverse-words-in-a-string/
    *
    *
    * */
    public static void main(String[] args) {

    }

    public static String reverseWords(String s) {

        char[] chars = s.toCharArray();
        int n = chars.length;
        // 先翻转整个字符串
        reverse(chars, 0, n);
        // 再翻转word
        reverseWords(chars, n);
        // 清理多余的空格
        return cleanSpaces(chars, n);
    }

    public static String cleanSpaces(char[] chars, int n){
        int i= 0, j = 0;

        while (j < n) {
            while (j < n && chars[j] == ' ') j++;
            while (j < n && chars[j] != ' ') chars[i++] = chars[j++];
            while (j < n && chars[j] == ' ') j++;
            if (j < n) chars[i++] = ' ';
        }

        return new String(chars, 0, i);
    }

    public static void reverseWords(char[] chars, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && chars[i] == ' ') i++; // 跳过空格
            while (j < i || j < n && chars[j] != ' ') j++; // 跳过非空格
            reverse(chars, i, j - 1);
        }
    }

    public static void reverse(char[] chars, int from, int to) {
        while (from < to) {
            char c = chars[from];
            chars[from++] = chars[to];
            chars[to--] = c;
        }
    }
}
