import java.util.*;
public class peopleAware {
	
	public static void main(String[] args) {
		int n = 6;
		int delay = 2;
		int forget = 4;
		int res = peopleAwareOfSecret2(n, delay, forget);
		System.out.println(res);
		
	}
	public static int peopleAwareOfSecret2(int n, int delay, int forget) {
		int[] DP = new int[n];
		DP[0] = 1;
		int mod = (int) (1e9 + 7);
		for(int i = 0; i < n; i++) {		
			for(int j = i + delay; j < Math.min(n, i + forget); j++) {
				DP[j] = (DP[j] + DP[i])% mod;
			}
		}
		int sum = 0;
		for(int i = n - forget; i < n; i++) {
			sum = (sum + DP[i]) % mod;
		}
	    return sum;
    }
	
	public static int peopleAwareOfSecret(int n, int delay, int forget) {
        // count represents the number of ppl each day, d is the delay each day f is the forget each day
		int[] count = new int[n];
		int[] d = new int[n];
		int[] f = new int[n];
		
		count[0] = 1;
		d[0] = delay;
		f[0] = forget;
		int start = 0;
		int mod = (int) (1e9 + 7);
		for(int i = 1; i < n; i++) {
			int curTotal = 0;
			// the day is i + 1.
			for(int j = start; j < i; j++) {
				// ignore 0 cases. 
				if(count[j] != 0) {
					if(i >= f[j]) {
						start = j + 1;
					}else if(i >= d[j]) {
						curTotal = (curTotal + count[j]) % mod;
					}
				}
			}
			// only add when greater than 0. 
			if(curTotal > 0) {
				count[i] = curTotal;
				d[i] = i + delay;
				f[i] = i + forget;
			}
			
		}
		
		int sum = 0;
		for(int i = start; i < n; i++) {
			sum = (sum + count[i]) % mod;
		}
		
		return sum;
    }
}
