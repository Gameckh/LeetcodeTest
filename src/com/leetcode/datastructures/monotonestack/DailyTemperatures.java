package com.leetcode.datastructures.monotonestack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    /*
    * https://leetcode.com/problems/daily-temperatures/
    *
    * 思路：
    *
    * */
    public static void main(String[] args) {

        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(res));
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> indices = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!indices.empty()) {
                int preIndex = indices.peek();
                if (temperatures[i] <= temperatures[preIndex]) {
                    break;
                }
                indices.pop();
                res[preIndex] = i - preIndex;
            }
            indices.push(i);
        }
        return res;
    }
}
