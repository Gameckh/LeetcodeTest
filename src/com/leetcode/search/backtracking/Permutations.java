package com.leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    /**
     * 思路：
     *  1. 要找出所有排列可能性，对于指定位置i，可以把i+1往后所有元素任意交换，直到试完所有可能性
     *  2. 每种可能性要保存之后，还需要恢复原数组，便于下一个节点(i+1)的计算
     * */
    public static void main(String[] args) {

        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, 0, result);
        return result;
    }

    public static void backtracking (int[] nums, int level, List<List<Integer>> result) {
        if (level == nums.length - 1) {
            List<Integer> entity = new ArrayList<>();
            for (int num : nums) entity.add(num);
            result.add(entity);
            return;
        }
        for (int i = level; i < nums.length; i++) {
            swap(nums, i, level);
            backtracking(nums, level + 1, result);
            swap(nums, i, level);
        }
    }

    public static void swap (int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
