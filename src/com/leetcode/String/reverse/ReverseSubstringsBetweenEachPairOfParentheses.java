package com.leetcode.String.reverse;

import java.util.Arrays;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    /*
    * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
    *
    * 按括号顺序，由内向外反转，同时要去掉括号返回结果。
    * Constraints:
    *   1 <= s.length <= 2000
    *   s only contains lower case English characters and parentheses.
    *   It is guaranteed that all parentheses are balanced.
    *
    * */
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair = new int[n];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(')
                opened.push(i);
            if (s.charAt(i) == ')') {
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        /*
        * 奇迹出现在这里：
        *   https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/discuss/383670/JavaC%2B%2BPython-Tenet-O(N)-Solution
        *   想象这是个虫洞，遇到左括号，从右括号出，遇到右括号，从左括号出：
        *   ->(<-   <-)->
        *   按这个逻辑，以 "(u(love)i)" 为例，其顺序就是：
        *   <-) i (-> love (-> u
        *   天才的解法，i像小球一样，在括号间弹跳，最后还能无重复路径走出。
        * */
        for (int i = 0, d = 1; i < n; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
