/**
 * Problem: LeetCode 121 - Best Time to Buy and Sell Stock
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * * Approach: Two Pointers / Sliding Window
 * Why: We maintain a 'minPrice' (buy price) as we iterate. If we find a lower 
 * price, we update 'minPrice'. If we find a higher price, we calculate the 
 * potential profit and update 'maxProfit'.
 * 
 * * Time Complexity: O(N) - We traverse the array exactly once.
 * Space Complexity: O(1) - Only two variables are used for tracking.
 */

class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = prices[0]; // The lowest price we've seen so far
        int maxProfit = 0;        // The maximum profit we can achieve

        for (int i = 1; i < prices.length; i++) {
            // If current price is lower than minPrice, update minPrice (New Buy Day)
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Otherwise, calculate profit if we sold today
                int currentProfit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }

        return maxProfit;
    }
}