package com.training.sorts.basic;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
    * Principle:
    * From the beginning to the end, every time the outer loop runs,
    * swapped the biggest element to the end of array.
    *
    * Steps:
    * 1. The outer loop from 1 to last element
    * 2. The inner loop from 0 to length - i
    * 3. If the front element bigger than the next, then swap them
    * 4. Make a flag, break the outer loop when the array has already been sorted.
    * */
    public static void sort(int[] nums) {

        // This flag is a tag for outer loop ended
        boolean isSwapped;
        for (int i = 1; i < nums.length; i++) {
            isSwapped = false;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
