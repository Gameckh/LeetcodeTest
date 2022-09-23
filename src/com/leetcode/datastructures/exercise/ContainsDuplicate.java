package com.leetcode.datastructures.exercise;

import java.util.HashSet;

public class ContainsDuplicate {

    /*
    * https://leetcode.com/problems/contains-duplicate/
    *
    * 思路：用set判断
    * */
    public static void main(String[] args) {

    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        return ! (set.size() == nums.length);
    }
}
