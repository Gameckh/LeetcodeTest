package com.leetcode.String.compare;

public class IsomorphicStrings {

    /*
    * https://leetcode.com/problems/isomorphic-strings/
    *
    * 思路：
    *   记录两个字符串每个位置的字符第一次出现的位置，如果两个字符串中相同位置的字符与它们第一次出现的位置一样，
    * 那么这两个字符串同构。举例来说，对于“paper”和“title”，假设我们现在遍历到第三个字符“p”和“t”，发现它们
    * 第一次出现的位置都在第一个字符，则说明目前位置满足同构。
    * */
    public static void main(String[] args) {
        String s = "paper", t = "title";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] sFirstIndex = new int[256];
        int[] tFirstIndex = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (sFirstIndex[s.charAt(i)] != tFirstIndex[t.charAt(i)]) return false;
            // 这里的i+1只是标记，对于不同位置的相同字符，值保证一样即可，但又不能跟其他字符混淆，所以用自增i，+1是为了跟默认值0区分。
            sFirstIndex[s.charAt(i)] = tFirstIndex[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
