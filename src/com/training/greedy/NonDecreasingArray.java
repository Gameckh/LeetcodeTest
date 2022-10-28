package com.training.greedy;

public class NonDecreasingArray {

    /*
    * https://leetcode.com/problems/non-decreasing-array/description/
    *
    * Problem-solving ideas:
    *   1. First of all, we should realize that we need travers nums and compare nums[i] and nums[i-1]
    *   2. The most important is, when found any element is non-decreasing, we have two ways to
    *           modify the neighboring elements —— change the front one or the back one.
    * */
    public static void main(String[] args) {
        int[] nums = {4,5,2,3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if (n <= 1) return true;
        int count = 0;
        // when we add this condition(&& modifyCount <= 1), runtime will beats 100%.
        for (int i = 1; i < n && count <= 1; i++) {
            if (nums[i] < nums[i-1]) {
                count++;
                /*
                * Two situations:
                * 1. When i equals one, or nums[i-2] less than or equals num[i],
                *       that means current i-1 value is the first value we are handling,
                *       Or nums[i-2] meet this condition(smaller than current nums[i]).
                *       That means the nums[i-1] is bigger than our expectation.
                * 2. Or second situation, that means the nums[i] is smaller than our expectation.
                *       we change the smaller value to equals nums[i-1]
                * */
                if ( i == 1 || nums[i-2] <= nums[i]) {
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
            }
        }
        // Notice: If the nums already IS non-decreasing, that is OK.
        return count <= 1;
    }
}
