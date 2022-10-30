package com.training.binarysearch;

public class FindMinimumInRotatedSortedArrayII {

    /*
    * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
    * */
    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        int[] nums1 = {1,3,5};
        System.out.println(findMin(nums1));
    }

    /*
    * Difference between the Find Minimum in Rotated Sorted Array is:
    * 1. check if the middle value equals left value, then move the left pointer forward.
    * 2. check if the middle index at the range which has the smallest value, remember use LESS THAN OR EQUALS.
    * */
    public static int findMin(int[] nums) {
        int min = nums[0];
        int left = 0, right = nums.length - 1, middle;
        while (left <= right) {
            middle = (left + right)/2;
            min = Math.min(min, nums[middle]);
            if (nums[middle] == nums[left]) {
                left++;
            } else if (nums[middle] <= nums[right]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return min;
    }
}
