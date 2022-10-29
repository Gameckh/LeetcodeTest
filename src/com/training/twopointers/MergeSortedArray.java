package com.training.twopointers;

import java.util.Arrays;

public class MergeSortedArray {

    /*
    * https://leetcode.com/problems/merge-sorted-array/
    *
    * Problem-resolving ideas:
    * This problem has an interesting and very important feature: nums1 has n positions for nums2.
    * So we could travers them from back to front, then we have enough positions for value insert.
    *
    * 1. We need three points for nums1 end, nums2 end and the result index position.
    * 2. Then we compare the elements of the two arrays from back to front.
    * 3. And we need continue to travers nums2 until end2 equals zero.
    * */
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) return;
        int end1 = m - 1, end2 = n - 1, pos = m + n - 1;
        while (end1 >= 0 && end2 >= 0) {
            if (nums2[end2] > nums1[end1]) {
                nums1[pos] = nums2[end2];
                pos--;
                end2--;
            } else {
                nums1[pos] = nums1[end1];
                pos--;
                end1--;
            }
        }
        while (end2 >= 0) {
            nums1[pos--] = nums2[end2--];
        }
    }
}
