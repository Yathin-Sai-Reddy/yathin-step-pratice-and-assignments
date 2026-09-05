public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int lowestPrice = prices[0];
        int maximumProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - lowestPrice;
            if (currentProfit > maximumProfit) {
                maximumProfit = currentProfit;
            }
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }
        }
        return maximumProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}