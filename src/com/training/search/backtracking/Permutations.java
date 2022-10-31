package com.training.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    /*
    * https://leetcode.com/problems/permutations/
    * */
    public static void main(String[] args) {

        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, 0, res);
        return res;
    }

    /*
    * Backtracking solution:
    * 1. Use the origin array to check every probably permutations.
    * 2. Save the permutations;
    * 3. Recover the origin array for next check.
    * */
    private static void backtracking(int[] nums, int level, List<List<Integer>> res) {
        if (level == nums.length) {
            List<Integer> entity = new ArrayList<>();
            for (int num : nums) entity.add(num);
            res.add(entity);
            return;
        }
        for (int i = level; i < nums.length; i++) {
            swap(nums, i, level);
            backtracking(nums, level+1, res);
            swap(nums, i, level);
        }
    }

    private static void swap (int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
