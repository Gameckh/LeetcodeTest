package com.leetcode.String.compare;

public class LongestPalindromicSubstring {

    /*
    * https://leetcode.com/problems/longest-palindromic-substring/
    *
    * 思路：
    *   1. 解法一（O(n^2)）：从每一个字符开始，向两边找最长回文substring，需要分别计算奇数和偶数个数的子序列
    *       注意，是区分奇数和偶数个数的回文子序列，这个跟s的奇偶性没关系！！而且每个位置都要排查奇数和偶数的可能substring
    *   2. 解法二（O(n)）：Manacher算法：https://blog.csdn.net/ggggiqnypgjg/article/details/6645824
    * */
    public static void main(String[] args) {
        String s = "cbbd";
        s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        return longestPalindromeTwoPointer(s);
    }

    // 解法一（O(n^2)）：从每一个字符开始，向两边找最长回文substring，需要分别计算奇数和偶数个数的序列
    public static String longestPalindromeTwoPointer(String s){
        int n = s.length();
        int palindromeLength = 0;
        String palindrome = "";

        for (int i = 0; i < n; i++) {
            // odd
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l >= palindromeLength) {
                    palindrome = s.substring(l, r + 1);
                    palindromeLength = palindrome.length();
                }
                l--;
                r++;
            }

            l = i; r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l >= palindromeLength) {
                    palindrome = s.substring(l, r + 1);
                    palindromeLength = palindrome.length();
                }
                l--;
                r++;
            }
        }
        return palindrome;
    }

    // 解法二（O(n)）：Manacher算法：https://blog.csdn.net/ggggiqnypgjg/article/details/6645824
    public static String longestPalindromeWithManacher(String s){
        return "";
    }

}
