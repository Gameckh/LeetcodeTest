package com.training.binarysearch;

public class FindMinimumInRotatedSortedArray {

    /*
    * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
    * */
    public static void main(String[] args) {
        int[] nums = {5,1,2,3,4};
        int[] nums1 = {3,1};
        System.out.println(findMin(nums1));
    }

    /*
    * Problem-Solution:
    * 1. Check the nums array to see if it needs to be searched.
    * 2. The smallest value in the sorted and rotated array, is at the middle of the array.
    * 3. We use binary search, check (the condition) if the first element mort than the middle index element,
    *       and we move the range into the area where contain the pivot value.
    * 4. We can lock on the pivot value by the condition that middle more than middle + 1, or middle less than middle - 1.
    * */
    public static int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length-1, middle;
        // The array wasn't rotated
        if (nums[left] < nums[right]) return nums[left];
        while(left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] > nums[middle+1]) {
                return nums[middle+1];
            }
            if (nums[middle] < nums[middle-1]){
                return nums[middle];
            }
            if (nums[0] > nums[middle]) {
                // This condition means middle at the ascending range
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
