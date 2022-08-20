package com.leetcode.sorts;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {

        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length - 1;

        while (white <= blue) {
            if (nums[white] == 0) {
                swap(nums, red++, white++);
            } else if (nums[white] == 1) {
                white ++;
            } else {
                swap(nums, white, blue);
                blue --;
            }
        }
    }
    
    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
