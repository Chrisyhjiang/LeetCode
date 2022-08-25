// https://leetcode.com/problems/paint-fence/
import java.util.*;
public class paintFence {
	
	public static void main(String[] args) {
		int n = 7;
		int k = 2;
		int ans = numWays(n,k);
		System.out.println(ans);
	}
	public static int numWays(int n, int k) {
		if(n == 1) {
			return k;
		}
		if(n == 2) {
			return k * k;
		}
        int[][] DP = new int[n+1][2];
        DP[1][0] = k;
        int sameColor = 1;
        for(int i = 2; i <= n; i++) {
        	DP[i][1] = (k - 1) * (DP[i-1][0] + DP[i-1][1]);
        	if(sameColor < 2) {
        		DP[i][0] = DP[i-1][0] + DP[i-1][1];
        		sameColor++;
        	}else {
        		DP[i][0] = DP[i-1][1];
        	}
        	
        }
        return DP[n][0] + DP[n][1];
    }
	
	
}
