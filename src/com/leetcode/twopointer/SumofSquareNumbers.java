package com.leetcode.twopointer;

import java.math.BigDecimal;

public class SumofSquareNumbers {

    public static void main(String[] args) {
        System.out.println(BigDecimal.valueOf(Math.pow(2, 31)).toString());
        //2147483648
        //2147483600
        System.out.println(judgeSquareSum(2147483600));
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i + ": " + judgeSquareSum(i));
//        }
    }

    public static boolean judgeSquareSum(int c) {

        long left = 0, right = (long)Math.sqrt(c);

        while (left <= right) {
            long sumSquare = left * left + right * right;
            if (sumSquare > c) {
                right --;
            } else if (sumSquare < c) {
                left ++;
            } else {
                System.out.println(left + ":" + right);
                return true;
            }
        }
        return false;
    }
}
