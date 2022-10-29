package com.training.twopointers;

public class ValidPalindromeII {


    /*
    * https://leetcode.com/problems/valid-palindrome-ii/description/
    *
    * Problem-solving ideas:
    * 1. Create two pointers to compare the characters of the given string.
    * 2. Left start from 0th index and right start from last index to check.
    * 3. If the character at lp equals rp, then keep checking lp++ and rp--.
    * 4. If they are not equal, check one offset to lp and rp respectively.
    * 5. If they are not equal again, return false.
    * */
    public static void main(String[] args) {
        String s = "aba";
        s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int lp = 0;
        int rp = s.length()-1;
        while (lp <= rp) {
            if (s.charAt(lp) != s.charAt(rp)) {
                return isPalindrome(s, lp + 1, rp) || isPalindrome(s, lp, rp - 1);
            }
            lp++;
            rp--;
        }
        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while(i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
