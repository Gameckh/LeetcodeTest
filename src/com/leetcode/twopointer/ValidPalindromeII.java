package com.leetcode.twopointer;

public class ValidPalindromeII {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {

        int left = 0, right = s.length() - 1;

        while (left < right) {
            char charL = s.charAt(left), charR = s.charAt(right);
            if (charL != charR) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left ++;
            right --;
        }
        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }

        return true;
    }
}
