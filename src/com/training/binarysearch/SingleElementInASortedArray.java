package com.training.binarysearch;

public class SingleElementInASortedArray {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int[] nums1 = {1,2,2,3,3};
        System.out.println(singleNonDuplicate(nums1));
    }

    /*
    * Binary search:
    * The key point of the solution is how to check which range contains the single value.
    * Be careful, the condition of the range check is easily out of bound exception.
    * */
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1, middle;
        while (left < right) {
            middle = (left + right)/2;
            if ( (middle % 2 == 0 && nums[middle] == nums[middle+1]) || (middle % 2 == 1 && nums[middle] == nums[middle-1]) ) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return nums[left];
    }
}
