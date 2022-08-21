package com.leetcode.String.reverse;

public class ReverseOnlyLetters {

    /*
    * https://leetcode.com/problems/reverse-only-letters/
    *
    *
    * */
    public static void main(String[] args) {
        String s = "ab-cd";
        System.out.println(reverseOnlyLetters(s));
        s = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s));
        s = "Test1ng-Leet=code-Q!";
        System.out.println(reverseOnlyLetters(s));
        s = "7_28]";
        System.out.println(reverseOnlyLetters(s));
    }

    public static String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            // 注意完全没有letter的case
            while (!isLetter(chars[i]) && i < j) i++;
            while (!isLetter(chars[j]) && j > i) j--;
            char t = chars[i];
            chars[i++] = chars[j];
            chars[j--] = t;
        }
        return new String(chars);
    }

    public static boolean isLetter(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

}
