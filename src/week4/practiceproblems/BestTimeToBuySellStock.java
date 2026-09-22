package week4.practiceproblems;
    public class BestTimeToBuySellStock {

        public static int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE; // lowest price seen so far
            int maxProfit = 0;                // best profit found

            for (int price : prices) {
                // Update lowest price if current price is lower
                if (price < minPrice) {
                    minPrice = price;
                }
                // Calculate profit if selling today
                int profit = price - minPrice;
                // Update max profit if this profit is higher
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }

            return maxProfit;
        }

        public static void main(String[] args) {
            // Sample inputs
            int[] prices1 = {7, 1, 5, 3, 6, 4};
            System.out.println(maxProfit(prices1)); // 5 (buy at 1, sell at 6)

            int[] prices2 = {7, 6, 4, 3, 1};
            System.out.println(maxProfit(prices2)); // 0 (no profit possible)
        }
    }

