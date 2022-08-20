package com.leetcode.sorts;

import java.util.Arrays;

public class MergeSort {

    /**
     * 归并排序思路：
     * 利用递归来分割数组，把数组分割成最小区间，这样每个区间都是有序的
     * 利用临时空间，通过3个指针把两个临时数组的值，按顺序合并到主数组中
     *
     * 重点：
     *  1. 递归 —— 下标，前闭后闭
     *  2. 临时空间 —— 拷贝数组作为临时空间，用于合并操作
     *  3. 3个指针 —— 合并时，1个指针指向主数组，2个指针分别指向临时空间的前后两半数组起点
     *  4. 4个条件 —— (1) 前/后半部分数组已遍历完；(2) 前后对应数组元素比大小。
     * */
    public static void main(String[] args) {

        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        int[] nums1 = {8,6,2,3,1,5,7,4};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums) {

        int len = nums.length;
        if (len == 0) return;

        partition(nums, 0, len - 1);
    }

    public static void partition(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        partition(nums, left, mid);
        partition(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {

        // copyOfRange是个左闭右开的方法，所以必须给right + 1
        int[] temp = Arrays.copyOfRange(nums, left, right + 1);

        int front = left, back = mid + 1;
        for (int i = left; i <= right; i++) {
            if (back > right) {
                nums[i] = temp[front - left];
                front ++;
            } else if (front > mid) {
                nums[i] = temp[back - left];
                back ++;
            } else if (temp[front - left] < temp[back - left]) {
                nums[i] = temp[front - left];
                front ++;
            } else {
                nums[i] = temp[back - left];
                back ++;
            }
        }
    }

}
