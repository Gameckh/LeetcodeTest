package com.training.search.backtracking;

import java.util.*;

public class PermutationsII {

    /*
    * https://leetcode.com/problems/permutations-ii/description/
    * */
    public static void main(String[] args) {
        int[] nums = {2,2,1,1};
        System.out.println(permuteUnique(nums));
    }

    /*
    * https://leetcode.com/problems/permutations-ii/solutions/875108/permutations-ii/
    * All the solution steps are described in detail in the official's article.
    * */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int n :nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        LinkedList<Integer> combination = new LinkedList<>();
        backtracking(combination, nums.length, counter, res);
        return res;
    }

    private static void backtracking(LinkedList<Integer> combination, int N, HashMap<Integer, Integer> counter, List<List<Integer>> res) {
        if (combination.size() == N) {
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (count == 0) continue;
            combination.addLast(num);
            counter.put(num, count - 1);
            backtracking(combination, N, counter, res);
            combination.removeLast();
            counter.put(num, count);
        }
    }
}
