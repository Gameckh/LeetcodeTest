package com.leetcode.String.understand;

public class BasicCalculatorII {

    /*
    * https://leetcode.com/problems/basic-calculator-ii/
    *
    * 字符串计算器：
    *   1. 计算的中间结果不超过Integer.max / min
    *   2. 遇到小数，不进位，直接truncate
    *
    * Constraints:
    *   1 <= s.length <= 3 * 105(10的5次方)
    *   s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
    *   s represents a valid expression.
    *   All the integers in the expression are non-negative integers in the range [0, 231 - 1].
    *   The answer is guaranteed to fit in a 32-bit integer.
    *
    * 思路：
    *   1. 所有数字都是两两计算的
    *   2. 按优先级，*、/ 再计算 +、-
    *   3. 需要考虑数字的前置0
    * */
    public static void main(String[] args) {

    }

    public int calculate(String s) {

        return 0;
    }
}
