import java.util.ArrayList;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

public class buySellStock {

	public static void main(String[] args) {
		int[] prices = {3,3,5,0,0,3,1,4};
		int res = maxProfit3(prices);
		System.out.println(res);
	}
	public static int maxProfit(int prices[]) {
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
	public static int maxProfit2(int[] prices) {
		int res = 0;
        for(int i = 0; i < prices.length - 1; i++) {
        	int cur = prices[i];
        	int next = prices[i+1];
        	if(next > cur) {
        		res += next - cur;
        	}
        }
        return res;
	}
	public static int maxProfit3(int[] prices) {
		if(prices.length <= 1) {
        	return 0;
        }else if (prices.length == 2 && prices[1] > prices[0]) {
        	return prices[1] - prices[0];
        }else {
        	int[][] dp = new int[prices.length][2];
        	// row number is day column number is bought or not;
        	// 0 index is not kept, 1 index is kept
        	dp[0][0] = 0; // first day no buy
        	dp[0][1] = -1 * prices[0]; // first day buy;
        	dp[1][0] = Math.max(0, dp[0][1] + prices[1]); // second day without = maximum between carry over and not bought on 1st day but bought on seccond day;
        	dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]); // second day with = max between carry over and not bought yester day bought today
        	for(int i = 2; i < dp.length; i++) {
        		dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        		dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        	}
        	return dp[dp.length - 1][0];
        }
	}
	
	public static int maxProfit4(int[] prices, int fee) {
		if(prices.length <= 1) {
			return 0;
		}else if (prices.length == 2 && prices[1] - prices[0] > fee) {
			return prices[1] - prices[0] - fee;
		}else {
			int[][] dp = new int[prices.length][2];
			dp[0][0] = 0;
			dp[0][1] = -1 * prices[0];
			dp[1][0] = Math.max(0, dp[0][1] + prices[1] - fee);
			dp[1][1] = Math.max(dp[0][1], -prices[1]);
			for(int i = 2; i < dp.length; i++) {
				dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
				dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
			}
			return dp[dp.length - 1][0];
 		}
	}
	public static int maxProfit4ver2(int[]prices, int fee){
		int cash = 0;
		int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
	}
	
}
