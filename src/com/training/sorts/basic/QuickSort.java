package com.training.sorts.basic;

import java.util.Arrays;

public class QuickSort {

    /*
    * Divide and Conquer: 分治法
    * Quick Sort also named as Partition-Exchange sort
    *
    * Steps:
    * 1. Find a pivot value, generally is the first element or the last one.
    * 2. Swap other elements which less than the pivot value in the left half, and bigger than the pivot value in the right half.
    * 3. Then put the pivot value to the middle position which is the border of the two halves.
    * 4. Recursive run the partition method for start to left-1, and left + 1 to end.(left position is the pivot value)
    *
    * Optimization:
    * 1. Use the InsertionSort when the partition elements less than a certain count.
    * 2. If the nums is a Completely Sorted Array, then our Quick Sort will be a O(n^2) time complexity if we select pivot value at left or right every time.
    *   So we can change the logic as we use a random selection for the pivot value.
    * */
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort (int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int start, int end) {
//        if (start >= end) return;
        // Optimize Point 1:
        // Use Insertion Sort to optimize when the partition elements nums less than a certain count.
        if (end - start < 15) {
            insertionSort(nums, start, end);
            return;
        }
        // Optimize Point 2:
        // Select the random position instead of a fixed position:

        swap(nums, end, (int)(Math.random() * (end - start + 1) + start));

        // select the pivot value as the last one of start-end
        int mid = nums[end];
        // right = end - 1 because we already select one element nums[end]
        int left = start, right = end - 1;
        while (left < right) {
            // Pass all elements at left that less than mid
            while (nums[left] <= mid && left < right)
                left++;
            // Pass all elements at right that bigger than mid
            while (nums[right] >= mid && left < right)
                right--;
            // swap the big element in the left and small element in the right
            swap(nums, left, right);
        }
        // if the left element is bigger than mid, then swap them
        // else, stay the left element
        if (nums[left] > mid)
            swap(nums, left, end);
        else
            left++;
        // notice here jump one element that is the Mid.
        sort(nums, start, left-1);
        sort(nums, left+1, end);
    }

    private static void insertionSort(int[] nums, int left, int right) {
        for (int i = 1; i <= right; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j-1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    private static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
