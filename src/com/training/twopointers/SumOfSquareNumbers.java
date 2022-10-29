package com.training.twopointers;

public class SumOfSquareNumbers {


    /*
    * https://leetcode.com/problems/sum-of-square-numbers/description/
    *
    * Problem-solving ideas:
    * A two-pointer question, be careful:
    * 1. middle variables should be long type
    * 2. left from zero to front, and right from sqrt c to back, that because the biggest value a & b can get is sqrt c;
    * 3. when sumSquare bigger than c, slid right 1 offset, vice versa, unless sumSquare equals c.
    * */
    public static void main(String[] args) {
        int c = 5;
        System.out.println(judgeSquareSum(c));
    }

    public static boolean judgeSquareSum(int c) {
        long left = 0, right = (long) Math.sqrt(c);
        while(left <= right) {
            long sumSquare = left*left + right*right;
            if (sumSquare > c){
                right--;
            } else if (sumSquare < c) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
}
