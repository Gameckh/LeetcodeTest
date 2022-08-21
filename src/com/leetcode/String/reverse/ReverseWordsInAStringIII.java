package com.leetcode.String.reverse;

public class ReverseWordsInAStringIII {

    /*
    * https://leetcode.com/problems/reverse-words-in-a-string-iii/
    *
    * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
    *
    * Constraints:
    *   1 <= s.length <= 5 * 104
    *   s contains printable ASCII characters.
    *   s does not contain any leading or trailing spaces.
    *   There is at least one word in s.
    *   All the words in s are separated by a single space.
    *
    * */
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        s = "God Ding";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        while (j < chars.length) {
            while (i < chars.length && chars[i] == ' ') i++;
            j = i;
            while (j < chars.length && chars[j] != ' ') j++;
            // to 是开区间，因为当退出while循环，也就是chars[j] == ' ' 时，j下标已经是空格了
            reverse(chars, i, j-1);
            i = j;
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
