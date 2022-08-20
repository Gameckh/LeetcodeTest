package com.leetcode.binarysearch;

public class SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if (x == 0)
            return 0;

        int l = 1, r = x, mid = 0, sqrt = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 对于类似8这种没有平方数的，不会走到sqrt==mid里，while结束后r就是最大开方整数
        return r;
    }
}
