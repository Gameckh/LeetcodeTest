package com.leetcode.greedy;

public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices1 = {1,2,3,4,5};
        int[] prices2 = {7,6,4,3,1};
//        int[] profits = {-6, 4, -2, 3, -2};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            maxProfit += Math.max(prices[i] - prices[i-1], 0);
        }
        return maxProfit;
    }

}
