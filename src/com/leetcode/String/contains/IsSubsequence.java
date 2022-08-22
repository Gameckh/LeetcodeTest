package com.leetcode.String.contains;

public class IsSubsequence {

    /*
    * https://leetcode.com/problems/is-subsequence/
    *   是否子序列的问题。几种解法，参考自：https://wizardforcel.gitbooks.io/the-art-of-programming-by-july/content/01.02.html
    *   1. O(m*n) 两个for循环嵌套
    *   2. 快速排序两个字符串数组，后用二分法查找。O(m log m) + O(n log n) + O(m+n)
    *   3. 质数相乘：利用质数的特性，把26个字符映射到26个质数上，再做相乘、求余的运算。O(m+n)，容易出现integer溢出问题
    *   4. 利用哈希表判断，实现简单，时间复杂度为O(m+n)
    *
    *   注意，跟参考中不同，本题实际上不能改变顺序，所以采用双指针方式实现。
    * */
    public static void main(String[] args) {
        String s = "axc", t = "ahbgdc";
        s = "acb"; t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int sIndex = 0, tIndex = 0;
        int sLen = s.length(), tLen = t.length();
        while (tIndex < tLen) {
            if (t.charAt(tIndex) == s.charAt(sIndex)) {
                sIndex++;
            }
            if (sIndex >= sLen) return true;
            tIndex++;
        }
        return false;
    }
}
