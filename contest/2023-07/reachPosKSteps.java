import java.math.BigInteger;
import java.util.Arrays;

public class reachPosKSteps {
	static long[][] DP;
	public static void main(String[] args) {
		System.out.println(numberOfWays(989,1000,99));
	}
	
	public static int numberOfWays(int startPos, int endPos, int k) {
		int[] dp = new int[3002];
	    startPos += 1000;
	    endPos += 1000;
	    dp[startPos] = 1;
	    for(int x = 0; x < k; x++){
	        int pre = 0;
	        for(int i = 0; i < 3001; i++){
	            int npre = dp[i];
	            dp[i] = (pre + dp[i+1]) % 1_000_000_007;
	            pre = npre;
	        }
	    }
	    return dp[endPos];
		
    }
	
	
	
}
