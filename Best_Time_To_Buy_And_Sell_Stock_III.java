/*
Best Time to Buy and Sell Stock III Total Accepted: 15023 Total Submissions: 67265 My Submissions
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        left[0] = 0;
        right[prices.length - 1] = 0;
        
        int min = prices[0];
        for (int i = 1; i < left.length; i++) {
            
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
            
        }
        
        int max = prices[right.length - 1];
        for (int i = right.length - 2; i >=0; i--) {
            
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        
        int total = 0;
        for (int i = 0; i < left.length; i++) {
            total = Math.max(total, left[i] + right[i]);
        }
        
        return total;
    }
}