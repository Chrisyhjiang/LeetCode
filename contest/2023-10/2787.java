class Solution {
    public int numberOfWays(int n, int x) {
        // when to take when not to take
        int mod = (int)(1e9 + 7);
        Long[] DP = new Long[n + 1];
        DP[0] = 1L;
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 1; j--) {
                int c = (int)Math.pow(i, x);
                if (c > n) {
                    break;
                }
                int remain = j - c;
                if (remain >= 0 && DP[remain] != null) {
                    if (DP[j] == null) {
                        DP[j] = 0L;
                    }
                    DP[j] += DP[remain];
                }
            }
        }

      
        if (DP[n] == null) {
            return 0;
        } else {
            return (int)(DP[n] % mod);
        }
    }
}