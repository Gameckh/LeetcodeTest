package com.training.binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    /*
    * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    * */
    public static void main(String[] args) {
        int[] nums = {5,7,7,7};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    /*
    * Like the C++ lower_bound and upper_bound methods.
    * */
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int lowerBound = lowerBound(nums, target);
        int upperBound = upperBound(nums, target);
        // When the target more than all elements in nums
        // lowerBound will be nums.length
        if (lowerBound == nums.length || nums[lowerBound] != target) {
            return res;
        }
        res[0] = lowerBound;
        res[1] = upperBound;
        return res;
    }

    // Find the first element which less than or equals target
    private static int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l)/2;
            // When middle element more than or equals target, find the left range.
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // Be careful!
        // lower bound must be the LEFT pointer
        // Why??
        // Because when the while loop is done, the right pointer already shifted before the left
        // combine with the condition: nums[mid] >= target, then nums[left] must correspond.
        // So, left > right, and left is verified, must be left.
        return l;
    }

    // Find the first element which MORE than target
    private static int upperBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l)/2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // upper bound should be right
        // and because this solution is using right closure method.
        return r;
    }
}
