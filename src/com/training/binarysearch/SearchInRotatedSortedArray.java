package com.training.binarysearch;

public class SearchInRotatedSortedArray {

    /*
    * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
    * */
    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 3;
        System.out.println(search(nums, target));
    }

    /*
    *
    * */
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, middle;
        while(left <= right) {
            middle = (left + right)/2;
            if (nums[middle] == target)
                return middle;
            // middle < right means the right range is ascending.
            if (nums[middle] < nums[right]) {
                // then binary search the target when it is between the middle and right
                if (target > nums[middle] && target <= nums[right]){
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                // else means the left range is ascending.
                if (target >= nums[left] && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return -1;
    }
}
