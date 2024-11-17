public class Solution {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int profit = price - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices;

        prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

        prices = new int[]{7, 6, 4, 3, 2, 1};
        System.out.println(maxProfit(prices));

        prices = new int[]{2, 4, 1};
        System.out.println(maxProfit(prices));

        prices = new int[]{3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(prices));
    }
}
