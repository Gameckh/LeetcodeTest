package com.leetcode.twopointer;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {

        int[] chars = new int[128];
        boolean[] flag = new boolean[128];

        for (int i = 0; i < t.length(); i++) {
            flag[t.charAt(i)] = true;
            ++chars[t.charAt(i)];
        }

        // Sliding Window width flag
        // 此变量是用于标记滑动窗口中是否已经完全包含了t字符串中的每个字符
        int cnt = 0;
        int left = 0;
        int minLeft = 0;
        // minSize用于标记s字符串中包含t所有字符的子串的最小长度
        int minSize = s.length() + 1;
        int right = 0;

        for (; right < s.length(); right++) {
            // 当右指针遇到了t中字符时
            if (flag[s.charAt(right)]) {
                // 命中t中字符后，给cnt加1，给chars标记位减1
                if (--chars[s.charAt(right)] >= 0) {
                    ++cnt;
                }
                // while循环是用来缩减sliding window的宽度的
                // 条件是滑窗中包含t的字符数等于t的总长度时（子String完整包含t中所有字符时，才移动left指针）
                while (cnt == t.length()) {
                    // 当sliding window宽度小于minSize（初始宽度为s的length）时
                    if ((right - left + 1) < minSize) {
                        minLeft = left;
                        minSize = right - left + 1;
                    }
                    // 当右移left时，遇到t中字符时（表示右移left会导致t中字符从sliding window中移出）
                    if (flag[s.charAt(left)] && ++chars[s.charAt(left)] > 0) {
                        --cnt;
                    }
                    // 把left指针持续右移
                    ++left;
                }
            }
        }

        // 判断：如果minSize超出s的宽度（默认值），表示在s中没找到t的字符集
        // 找到字符集后，截取s，范围是minSize最小值的记录
        return minSize > s.length()? "" : s.substring(minLeft, minLeft+minSize);
    }
}
