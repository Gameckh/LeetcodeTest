package com.leetcode.String.reverse;

public class ReversePrefixOfWord {

    /*
    * https://leetcode.com/problems/reverse-prefix-of-word/
    *
    *
    * */
    public static void main(String[] args) {
        String word = "abcd";
        char ch = 'z';
        System.out.println(reversePrefix(word, ch));
    }

    public static String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch) {
                reverse(chars, 0, i);
                break;
            }
        }
        return new String(chars);
    }

    public static void reverse(char[] chars, int from, int to) {
        while (from < to) {
            char c = chars[from];
            chars[from++] = chars[to];
            chars[to--] = c;
        }
    }
}
