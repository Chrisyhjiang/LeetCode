// https://leetcode.com/problems/sorting-three-groups/description/
class Solution {
    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        // dp[i][j] means the minimum operations it takes to ensure nums[0] -> nums[j] to be non decreasing. 
        // nums[j] = (i+1) 
        int[][] dp = new int[3][n];

        if (nums.get(0) == 1) {
            dp[1][0] = 1;
            dp[2][0] = 1;
        } else if (nums.get(0) == 2) {
            dp[0][0] = 1;
            dp[2][0] = 1;
        } else {
            dp[0][0] = 1;
            dp[1][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + ((nums.get(i) != 1) ? 1 : 0);
            dp[1][i] = Math.min(dp[0][i-1], dp[1][i-1]) + ((nums.get(i) != 2) ? 1 : 0);
            dp[2][i] = Math.min(dp[0][i-1], Math.min(dp[1][i-1], dp[2][i-1])) + ((nums.get(i) != 3) ? 1 : 0);
        }
        
        return Math.min(dp[0][n-1],Math.min(dp[1][n-1],dp[2][n-1]));
    }
}

