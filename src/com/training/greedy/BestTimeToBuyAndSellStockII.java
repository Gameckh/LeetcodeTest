package com.training.greedy;

public class BestTimeToBuyAndSellStockII {

    /*
    * Problem-solving ideas:
    * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/127712/best-time-to-buy-and-sell-stock-ii/
    * */
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        return maxProfitBySimpleOnePass(prices);
    }

    /*
    * Peak-Valley approach:
    *   This approach interests that the consecutive valleys and peaks of the elements.
    * We can prove that we should not skip every one of the valley-peak.
    *   Notice that we MUST find the valley fist in the while loop. Or we will get wrong
    * answer.
    * */
    private static int maxProfitByPeakValleyApproach(int[] prices) {
        int maxProfit = 0;
        int peak, valley;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i+1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i+1])
                i++;
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }

    /*
    * Simple One Pass approach:
    * Along with the Peak-Valley approach, we can get this approach simply.
    * */
    private static int maxProfitBySimpleOnePass(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
