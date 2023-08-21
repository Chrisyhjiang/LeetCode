// https://leetcode.com/problems/maximize-the-profit-as-the-salesman/

class Solution {
    class Pair {
        public int start;
        public int gold;
        Pair (int s, int c) {
            start = s;
            gold = c;
        }
    }
    public int maximizeTheProfit(int n, List<List<Integer>> m) {
        // maps end to (start, cost)
        HashMap<Integer, List<Pair>> hm = new HashMap<>();
        for (List<Integer> ls: m) {
            if (hm.containsKey(ls.get(1))) {
                hm.get(ls.get(1)).add(new Pair(ls.get(0), ls.get(2)));
            } else {
                ArrayList<Pair> e = new ArrayList<Pair>();
                e.add(new Pair(ls.get(0), ls.get(2)));
                hm.put(ls.get(1), e);
            }
        }
        // DP[n] array represents the max cost up to n. 
        int[] dp = new int[n + 1]; 

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1];
            List<Pair> offers = hm.get(i - 1);
            if (offers != null) {
                for (Pair o: offers) {
                    dp[i] = Math.max(dp[i], dp[o.start] + o.gold);
                }
            }
            
        }
        return dp[n];
    }
}

