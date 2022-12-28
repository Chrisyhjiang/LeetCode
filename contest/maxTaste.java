import java.util.*;
// https://leetcode.com/problems/maximum-tastiness-of-candy-basket/description/
import java.util.*;
public class maxTaste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maximumTastiness(int[] price, int k) {
		int n = price.length;
        Arrays.sort(price);
        int low = 0;
        // to prevent division by 2 errors. 
        int up = price[n - 1] - price[0] + 1;
        // binary search for the answer, which is the minimum of the difference. 
        
        while(low < up) {
        	int mid = (low + up) / 2;
        	// if the current difference works then check if there is a higher difference. 
        	if(verify(mid, price, k)) {
        		low = mid + 1;
        	}else {
        		// else check for the exact difference underneath mid. 
        		up = mid;
        	}
        	
        }
        return low - 1;
    }
	
	public boolean verify(int target, int[] prices, int k) {
		// checks if there are at least k prices above the target price. 
		int last = prices[0]; 
		int count = 1;
		int i = 1;
		while(count < k && i < prices.length) {
			if(prices[i] - last >= target) {
				last = prices[i];
				count++;
			}
			i++;
		}
		
		return count == k;
	}

}
