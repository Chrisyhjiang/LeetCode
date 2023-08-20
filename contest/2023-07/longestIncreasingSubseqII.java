import java.util.*;
public class longestIncreasingSubseqII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLIS(int[] nums, int k) {
		int global = Integer.MIN_VALUE;
		int[] DP = new int[nums.length];
		DP[DP.length - 1] = 1;
		for(int i = DP.length - 2; i >= 0; i--) {
			int max = 0;
			for(int j = i + 1; j < DP.length; j++) {
				
			}
			DP[i] = max;
			global = Math.max(max, global);
		}
		return global;
    }

}
