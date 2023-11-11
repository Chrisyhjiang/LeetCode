class Solution {

    class Pair {
        int m;
        int n;
        Pair(int a, int b) {
            m = a;
            n = b;
        }
    }
    public int findMaxForm(String[] strs, int m, int n) {
        
        int[][] DP = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] cnt = count(s);
            for (int i = m; i >= cnt[0]; i--) {
                for (int j = n; j >= cnt[1]; j--) {
                    DP[i][j] = Math.max(DP[i][j], DP[i - cnt[0]][j - cnt[1]] + 1);
                }
            }
        }
        return DP[m][n];

    }


    public int[] count(String s) {
        int[] res = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                res[0]++;
            } else {
                res[1]++;
            }
        }
        return res;
    }
}