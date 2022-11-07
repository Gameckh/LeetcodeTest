package com.training.search.backtracking;

import java.util.*;

public class CombinationSumII {

    /*
    * https://leetcode.com/problems/combination-sum-ii/
    * */
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    /*
    * In PermutationsII, we need to select the duplicate candidates for different combinations,
    * But in this problem, we just get a sum and don't choose the same candidates more than once.
    * So we sort the given candidates array at first, and jump over the duplicate candidates when exclude the backtracking.
    * Think why...
    *   That because we already selected the element at the inclusive stage, when out of the recursive, we pass them all.
    * */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        Arrays.sort(candidates);
        backtracking(0, combination, candidates, target, 0, results);
        return results;
    }

    private static void backtracking(int sum, LinkedList<Integer> combination,
            int[] candidates, int target, int position, List<List<Integer>> results) {
        if (sum > target) return;
        if (sum == target) {
            results.add(new ArrayList<>(combination));
            return;
        }
        if (position >= candidates.length) return;

        // include
        sum += candidates[position];
        combination.addLast(candidates[position]);
        backtracking(sum, combination, candidates, target, position + 1, results);

        // exclude
        sum -= candidates[position];
        combination.removeLast();
        // When get over the current position element, we pass all same candidates.
        while (position + 1 < candidates.length && candidates[position] == candidates[position + 1]) {
            position++;
        }
        // and go on for next position.
        backtracking(sum, combination, candidates, target, position + 1, results);
    }
}
