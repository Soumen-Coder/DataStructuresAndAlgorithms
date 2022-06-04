package arrays;

public class BuyAndSellStocks {
    public static void main(String[] args) {

        int[] prices = {7,1,5,4,6,2};

        int maxProfit = buyAndSellStocks(prices);
        System.out.println(maxProfit);
    }

    private static int buyAndSellStocks(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if(prices[i]< minPrice){
                minPrice = prices[i];
            }

            if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }

        }
        return maxProfit;
    }
}
