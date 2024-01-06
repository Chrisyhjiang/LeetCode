package LIS;
// https://leetcode.com/problems/longest-increasing-subsequence/
public class longestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = {7,7,7,7,7,7,7};
		int res = lengthOfLIS(nums);
		System.out.println(res);
	}
	public static int lengthOfLIS(int[] nums) {
        int maxLength = -1;
        int len = nums.length;
        int[] DP = new int[len];
        DP[len - 1] = 1;
        int globalMax = 1;
        for(int i = nums.length - 2;i >= 0; i--) {
        	int max = 0;
        	for(int j = i; j < len; j++) {
        		if(nums[i] < nums[j]) {
        			max = Math.max(max, DP[j]);
        		}
        	}
        	DP[i] = max + 1;
        	globalMax = Math.max(globalMax, DP[i]);
        }
        return globalMax;
    }
}
