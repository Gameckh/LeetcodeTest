package com.training.sorts;

import java.util.Arrays;

public class MergeSort {

    /*
    * Divide and Conquer
    * Split the array to elements, and merge them by sort.
    * 1. partition: split the nums with given index left and right
    * 2. merge: merge the elements to nums with sort, three steps:
    *       <1> new two arrays to save the left to mid and mid to right elements
    *       <2> then merge them into nums with small element front and big element back
    *       <3> copy the left elements which bigger than another array.
    * */

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;
        // left closure and right closure
        partition(nums, 0, len - 1);
    }

    // split the nums in recursion
    public static void partition(int[] nums, int l, int r) {
        // Optimize Point 2:
        // When the elements for merge less than a certain amount, use insertion sort is faster
//        if (l < r) {
        if (r - l >= 15) {
            int mid = l + (r - l) / 2;
            partition(nums, l, mid);
            partition(nums, mid + 1, r);
            // Optimize Point 1:
            // If nums[mid] <= nums[mid+1] means the two partition is already ordered
            if (nums[mid] > nums[mid + 1])
                merge(nums, l, mid, r);
        } else {
            insertionSort(nums, l, r);
        }
    }

    public static void insertionSort(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }

    public static void merge(int[] nums, int l, int mid, int r) {

        int len1 = mid - l + 1;
        int len2 = r - mid;

        int[] left = new int[len1];
        int[] right = new int[len2];

        for (int i = 0; i < len1; i++) {
            left[i] = nums[l + i];
        }
        for (int i = 0; i < len2; i++) {
            right[i] = nums[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < len1 && j < len2) {
            if (left[i] < right[j]) {
                nums[k] = left[i++];
            } else {
                nums[k] = right[j++];
            }
            k++;
        }

        while (i < len1) {
            nums[k++] = left[i++];
        }
        while (j < len2) {
            nums[k++] = right[j++];
        }
    }


}
