class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean res = false;
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        if (m + n != l) {
            return false;
        }

        boolean[] DP = new boolean[n + 1];
        DP[0] = true;

        for (int j = 1; j <= n; j++) {
            DP[j] = DP[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        for (int i = 1; i <= m; i++) {
            DP[0] = DP[0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
            for (int j = 1; j <=n; j++) {
                DP[j] = (DP[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || 
                (DP[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }

        }
        return DP[n];
    }
}