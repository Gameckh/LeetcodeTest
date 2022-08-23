package com.leetcode.String.match;

public class ImplementStrStr {

    /*
    * https://leetcode.com/problems/implement-strstr/
    *
    * 题目理解：
    *   1. 功能类似java 的indexOf()
    *   2. 本题不考虑needle为空的情况
    *
    * 思路：
    *   0. 要考虑needle长度大于haystack的情况
    *   1. 遍历时不需要遍历整个haystack，i最大为hLen-nLen即可，闭区间，举例说明：
    *       haystack长度5，needle长度3，那么i必须走到2，判断2、3、4三个下标的字符才能得到正确结果
    *   2. 内部while循环中双指针，滑动窗口
    *   3. 结束判断，当needle找完时，nIndex==nLen，返回i即可
    * */
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
//        String haystack = "aaaaa", needle = "bba";
//        String haystack = "a", needle = "a";
//        String haystack = "mississippi", needle = "issip";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        int nLen = needle.length(), hLen = haystack.length();

        for (int i = 0; i <= hLen - nLen; i++) {
            int hIndex = i;
            int nIndex = 0;
            while (hIndex < hLen && nIndex < nLen) {
                if (haystack.charAt(hIndex) == needle.charAt(nIndex)) {
                    hIndex++;
                    nIndex++;
                } else
                    break;
            }
            if (nIndex == nLen) return i;
        }
        return -1;
    }

}
