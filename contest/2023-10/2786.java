class Solution {
    public long maxScore(int[] nums, int x) {
        // visit all the even points. 
        // probably use DP
        // DP[i] stands for max cost from i to the end of the array
        int n = nums.length;
        long[] DP = new long[n];
        // 0 for even one for odd
        int[][] parity = new int[n][2];
        parity[n - 1][0] = n;
        parity[n - 1][1] = n;
        int odd = n;
        int even = n;
        
        for (int i = n - 1; i >= 0; i--) {
            parity[i][0] = even;
            parity[i][1] = odd;
            if (nums[i] % 2 == 0) {
                even = i;
            } else {
                odd = i;
            }
        }
        DP[n - 1] = (long)nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            long a = (long)nums[i];
            long b = (long)nums[i];
            if (nums[i] % 2 == 0) {
                if (parity[i][0] != n) {
                    a += DP[parity[i][0]];
                }
                if (parity[i][1] != n) {
                    b += DP[parity[i][1]]- x;
                }
            } else {
                if (parity[i][0] != n) {
                    a += DP[parity[i][0]] - x;
                }
                if (parity[i][1] != n) {
                    b += DP[parity[i][1]];
                }
            }
            DP[i] = Math.max(a, b);
        }
        return DP[0];
    }
    // take yourself + the next odd 
    // so we need to track where the next even or odd one is
}