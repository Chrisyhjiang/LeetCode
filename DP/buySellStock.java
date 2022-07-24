// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class buySellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxProfit(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxGain = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxGain)
                maxGain = prices[i] - minPrice;
        }
        return maxGain;
    }
	public int maxProfit2(int[] prices) {
        
    }
	
}
