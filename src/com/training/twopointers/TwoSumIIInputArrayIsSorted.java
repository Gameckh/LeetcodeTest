package com.training.twopointers;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {

    /*
    * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    *
    * Problem-resolving ideas:
    * 1. Two pointers: left from beginning of the array, right from ending of the array.
    * 2. Be careful, the given array numbers IS already non-decreasing ordered,
    *       so we just need one loop and a sum variable.
    *       If sum bigger than target, then minus right, vice versa.
    * */
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] nums1 = {2,3,4};
        int target1 = 6;
        int[] nums2 = {-1, 0};
        int target2 = -1;
        System.out.println(Arrays.toString(twoSum(nums2, target2)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left+1;
                res[1] = right+1;
                return res;
            }
            if (sum > target) right--;
            else left++;
        }
        return res;
    }
}
