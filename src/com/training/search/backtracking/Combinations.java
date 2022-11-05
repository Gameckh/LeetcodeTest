package com.training.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    /*
    * https://leetcode.com/problems/combinations/
    * */
    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] comb = new int[k];
        backtracking(res, comb, 0, 1, n, k);
        return res;
    }

    /*
    * Problem solution:
    *   This problem is one of the typical backtracking problem types.
    * 1. We need an integer array for saving the middle result of the combination.
    * 2. The end of the recursion is when count equals k, because count means the number of elements we've got.
    * 3. The position pointer means the start number of the current combination.
    * 4. The for loop pointer index i, means the position offset.
    * */
    public static void backtracking(List<List<Integer>> res, int[] comb, int count, int position, int n, int k) {
        if(count == k) {
            List<Integer> entity = new ArrayList<>(n);
            for (int num: comb) {
                entity.add(num);
            }
            res.add(entity);
            return;
        }
        for (int i = position; i <= n; i++) {
            comb[count] = i;
            count++;
            backtracking(res, comb, count, i+1, n, k);
            count--;
        }
    }
}
