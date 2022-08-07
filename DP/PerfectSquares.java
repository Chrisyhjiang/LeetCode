import java.util.*;
// https://leetcode.com/problems/perfect-squares/
public class PerfectSquares {
	
	public static void main(String[] args) {
		int k = perfectSquares(12);
		System.out.println(k);
		
	}
	
	public static int perfectSquares(int n) {
		if(n <= 3) {
			return n;
		}else {
			// DP array caching the minimum values
			int[] DP = new int[n+1];
			Arrays.fill(DP, Integer.MAX_VALUE);
			DP[0] = 0;
			DP[1] = 1;
			DP[2] = 2;
			DP[3] = 3;
			for(int i = 4; i <= n; i++) {
				for(int j = (int) Math.sqrt(i); j >= 1; j--) {
					DP[i] = Math.min(DP[i - j*j] + 1, DP[i]);
				}
			}
			return DP[n];
		}
		
	}
	
	
}
