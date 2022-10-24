package com.training.sorts;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
    * Selection Sort Principle:
    * Every time the outer loop find the min value(or max value), and swap to the front or back of the array.
    *
    * Steps:
    * 0. Declare an int variable to mark the min/max value's index.
    * 1. The outer loop traverse elements from 0 to the element before last (because the inner loop will handle the last one).
    * 2. The inner loop traverse elements from next of i to last element
    * 3. When we found an element smaller than the min index value, the mark the min index flag.
    * 4. Swap the front element (i) and the min index element.
    * */
    public static void selectionSort (int[] nums) {
        int minIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
    }

    private static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
