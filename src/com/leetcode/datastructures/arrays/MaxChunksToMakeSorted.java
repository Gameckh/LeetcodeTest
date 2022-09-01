package com.leetcode.datastructures.arrays;

public class MaxChunksToMakeSorted {

    /*
    * https://leetcode.com/problems/max-chunks-to-make-sorted/
    *
    * 理解：
    *   注意，本题的题目要求比较难理解。
    *   给定一个含有 0 到 n 整数的数组，每个整数只出现一次，求这个数组最多可以分割成多少个
    * 子数组，使得对每个子数组进行增序排序后，原数组也是增序的。
    *   这里隐含了一个限制，就是只能对子数组内部的元素进行排序，不能对数组排序。
    *
    * 思路：
    *   从左往右遍历，同时记录当前的最大值，每当当前最大值等于数组位置时，我们可以多一次分割。
    *   为什么可以通过这个算法解决问题呢？如果当前最大值大于数组位置，则说明右边一定有小
    * 于数组位置的数字，需要把它也加入待排序的子数组；又因为数组只包含不重复的 0 到 n，所以
    * 当前最大值一定不会小于数组位置（最大值只能大于等于所在位置！）。
    *   所以每当当前最大值等于数组位置时，假设为 p，我们可以成功完成一次分割，并且其与上一次
    * 分割位置 q 之间的值一定是 q + 1 到 p 的所有数字。
    *
    *   换句话说，其实就是只有当最大值等于所在位置时，之前这段才可以完成排序，例如[2,1,0]。
    * */
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,4};
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int max = 0;
        int p = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                p++;
            }
        }
        return p;
    }
}
