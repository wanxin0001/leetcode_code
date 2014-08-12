/*
Best Time to Buy and Sell Stock Total Accepted: 19740 Total Submissions: 63402 My Submissions
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minVal = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (minVal > prices[i]) {
                minVal = prices[i];
            }
            profit = Math.max(profit, prices[i] - minVal);
        }
        return profit;
    }
}