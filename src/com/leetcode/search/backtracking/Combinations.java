package com.leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    /**
     * 题目理解：
     *  https://leetcode.com/problems/combinations/
     *  Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
     *      Constraints:
     *        1 <= n <= 20
     *        1 <= k <= n
     * 思路：
     *  1. 与上一题排列组合不同，本题回溯的是是否把当前数字放进来（count）
     *  2. count在backtracking返回后，需要恢复，类似level标记
     *  2. position从起点开始，随i变动，递归时传入i+1
     *
     *  变量解析：
     *  1. count: 本题目的关键变量，表示是否选满了k个数
     *  2. position: 开始选择的数字（按题目要求，从1开始）
     *  3. combine: 存储选择结果，当count等于k时，导出给result
     *
     * */
    public static void main(String[] args) {
        int n = 3, k = 3;
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] comb = new int[k];
        backtracking(result, comb, 0, 1, n, k);
        return result;
    }

    public static void backtracking (List<List<Integer>> result, int[] comb, int count, int position, int n, int k) {
        if (count == k) {
            List<Integer> entity = new ArrayList<>();
            for(int i: comb) entity.add(i);
            result.add(entity);
            return;
        }
        for (int i = position; i <= n; i++) {
            comb[count] = i;
            count ++;
            backtracking(result, comb, count, i + 1, n, k);
            count --;
        }
    }

}
