public class Solution {
    long[][] DP;
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        DP = new long[26][26];
        for (int i = 0; i < 26; i++)
        {
            Arrays.fill(DP[i], Integer.MAX_VALUE);
            DP[i][i] = 0;
        }

        for (int i = 0; i < changed.length; i++) {
            int src = original[i] - 'a';
            int tar = changed[i] - 'a';
            DP [src][tar] = Math.min(DP[src][tar], cost[i]);
        }

        populate();
        
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int src = source.charAt(i) - 'a';
            int tar = target.charAt(i) - 'a';

            if (src == tar) {
                continue;
            }
            if (DP[src][tar] == Integer.MAX_VALUE){
                return -1L;
            }
            else
            {
                ans += DP[src][tar];
            }
        }
        return ans;
    }
    // floyd warshall algorithm 
    public void populate() {
        for(int i=0;i<26;i++) {
            for(int j=0;j<26;j++) {
                for(int k=0;k<26;k++) {
                    DP[j][k]=Math.min(DP[j][k],DP[j][i]+DP[i][k]);
                }
            }
        }
    }
}