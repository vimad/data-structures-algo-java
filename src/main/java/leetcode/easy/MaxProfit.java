package leetcode.easy;


// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Greedy
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int result = 0;

        for (int price : prices) {
            if (price < min) {
                max = Integer.MIN_VALUE;
                min = price;
            } else if (price > max && min >= 0) {
                max = price;
                if (result < max - min) {
                    result = max - min;
                }
            }
        }

        return result;
    }
}
