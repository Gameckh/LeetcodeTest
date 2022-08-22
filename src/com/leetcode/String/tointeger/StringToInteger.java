package com.leetcode.String.tointeger;

public class StringToInteger {

    /*
    * https://leetcode.com/problems/string-to-integer-atoi/
    *   原题非常长，主要的限制与思路如下：
    *   1. 前置Spaces应该被忽略；
    *   2. 遇到+ - 号时，需要判断数字的正负；
    *   3. 遇到非法字符时，从非法字符往后的string应该被ignore掉
    *   4. 前置一个或多个0时，应忽略
    *   5. 如果超出Integer.MAX_VALUE的限制，应等于对应的最大、最小值
    *   Constraints:
    *       0 <= s.length <= 200
    *       s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
    *   思路：
    *   1. 最核心的思路，先什么都不考虑，先实现string转integer逻辑，以"123"为例：
    *       1 = 1
    *       1*10 + 2 = 12
    *       12*10 + 3 = 123
    *   2. 判断最大最小值时，不能用long或double，会有浮点进位导致输出错误（好像分平台）
    *       此时应判断前一位的大小
    * */
    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483647"));
    }

    public static int myAtoi(String s) {
        int n = s.length();
        int basic = '0';
        int i = 0;
        // 去掉前置空格
        while (i < n) {
            if (s.charAt(i) == ' ') i++;
            if (i < n && s.charAt(i) != ' ') break;
        }
        // 判断首字符是否为"+"/'-'
        boolean isNegative = false;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            isNegative = s.charAt(i) == '-';
            i++;
        }
        // 开始转数字
        int res = 0;
        while (i < n) {
            int cur = s.charAt(i) - basic;
            if (cur < 0 || cur > 9) break;
            if(Integer.MAX_VALUE/10 < res || Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE %10 < cur)
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res = res*10 + cur;
            i++;
        }
        return isNegative ? -1 * res : res;
    }
}
