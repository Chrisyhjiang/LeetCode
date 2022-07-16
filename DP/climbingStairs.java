
public class climbingStairs {
	public static void main(String[] args) {
		int n = climbStairs(3);
		System.out.println(n);
	}
	
	public static int climbStairs(int n) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		int[] DP = new int[n+1];
		DP[1] = 1;
		DP[2] = 2;
		for(int i = 3; i <= n; i++) {
			DP[i] = DP[i-1] + DP[i-2];
		}
		return DP[n];
    }
	
	public int minCostClimbingStairs(int[] cost) {
		if(cost.length == 1) {
			return cost[0];
		}else if (cost.length == 2) {
			return Math.min(cost[0], cost[1]);
		}
        int[] DP = new int[cost.length];
        DP[0] = cost[0];
        DP[1] = cost[1];
        for(int i = 2; i < DP.length; i++) {
        	DP[i] = Math.min(DP[i-1], DP[i-2]) + cost[i];
        }
        return Math.min(DP[cost.length-2], DP[cost.length - 3]);
    }
}
