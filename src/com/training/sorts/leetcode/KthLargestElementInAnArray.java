package com.training.sorts.leetcode;

import java.util.Arrays;
import java.util.Random;

public class KthLargestElementInAnArray {

    /*
    * https://leetcode.com/problems/kth-largest-element-in-an-array/
    * */
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 3;
        System.out.println(findKthLargest(nums, k));
    }

    /*
    * Quick Selection:
    * https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/2180600/a-guide-to-quick-select-java/
    *
    * In my own word, quick selection is:
    * 1. Quick selection is another form of quick sort, they have almost same ideas.
    * 2. Partition function:
    *       <1> Each execution will put the given element(pIndex) in the correct position, and return its position.
    *       <2> At the beginning, swap the pIndex and right first, then pIndex from left to right.
    *       <3> The for loop start with left and end with right(closure).
    *       <4> If num[i] less than or equals pivot value, then swap the pIndex and i, and pIndex increase one.
    *       <5> Return pIndex-1, because the pIndex++ has redundant once.
    * 3. Quick selection function:
    *       <1> Select a random pIndex, then find its correct position, then compare with k.
    *       <2> Check whether the range has only one element.
    *       <3> Get a random index between the left and right.
    *       <4> Call partition function and get the correct position of the element at pIndex.
    *       <5> Check k and pIndex, then go to different ranges.
    * */
    public static int findKthLargest(int[] nums, int k) {
        return quickSelection(nums, 0, nums.length-1, nums.length-k);
    }

    //
    private static int quickSelection(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        int pIndex = new Random().nextInt(right - left + 1) + left;

        pIndex = partition(nums, left, right, pIndex);

        if (pIndex == k) return nums[pIndex];
        if (pIndex < k) return quickSelection(nums, pIndex+1, right, k);
        return quickSelection(nums, left, pIndex-1, k);
    }

    /*
    * Swap a certain value(pIndex) to correct position, and return the position.
    * */
    public static int partition(int[] nums, int left, int right, int pIndex) {
        int pivot = nums[pIndex];
        swap(nums, pIndex, right);
        pIndex = left;

        for (int i = left; i <= right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pIndex++);
            }
        }
        return pIndex-1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
