package com.training.binarysearch;

public class SqrtX {

    /*
    * https://leetcode.com/problems/sqrtx/description/
    * */
    public static void main(String[] args) {
        int x = 10;
        long start1 = System.currentTimeMillis();
        System.out.println(mySqrt(x));
        long start2 = System.currentTimeMillis();
        System.out.println(newtonSqrt(x));
        long end = System.currentTimeMillis();
        System.out.println(start2 - start1);
        System.out.println(end - start2);
    }

    /*
    * Two-pointer & binary search:
    * Binary search will also use two pointers, but we don't treat them as the same thing.
    * Two-pointer moves pointers constant steps for one time(like one step), but BS don't.
    *
    * Problem-solution:
    * 1. if x equals zero, return zero first, this process will avoid divide zero error.
    * 2. while left pointer less than or equals right pointer, left closure and right closure.
    * 3. if sqrt equals mid, means the mid or sqrt is the result.
    * 4. if some number can not find sqrt directly, like 8, when left more than right,
    *       end the while loop, then the right pointer is the answer.
    * */
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1, r = x, mid = 0, sqrt = 0;
        while (l <= r) {
            mid = l + (r - l)/2;
            sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt > mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    //Newton's method
    // This method also named Newton-Raphson method.
    public static int newtonSqrt(int a) {
        long x = a;
        while (x*x > a) {
            x = (x + a/x)/2;
        }
        return (int)x;
    }
}
