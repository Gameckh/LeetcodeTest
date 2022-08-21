package com.leetcode.String.reverse;

public class ReverseString {

    /*
    * https://leetcode.com/problems/reverse-string/
    *
    * 字符串类型题目的基础：反转字符串
    * https://wizardforcel.gitbooks.io/the-art-of-programming-by-july/content/01.01.html
    * 上文有两个重要知识点：
    *   1. 如本题目的反转字符串算法
    *   2. (X^TY^T)^T=YX
    * */
    public static void main(String[] args) {

    }

    public static void reverseString(char[] s) {
        if(s == null || s.length <= 1) return;
        int i = 0, j = s.length-1;
        while(i < j) {
            char c = s[i];
            s[i++] = s[j];
            s[j--] = c;
        }
    }
}
