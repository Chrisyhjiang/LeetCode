class Solution {
    int[][] DP;
    List<Integer> ls;
    int n;
    public int change(int amount, int[] coins) {
       int[] DP = new int[amount + 1];
       DP[0] = 1;
       int coin;
       for (int i = 0; i < coins.length; i++) {
           for (int j = coins[i]; j <= amount; j++) {
               coin = coins[i];
               DP[j] = DP[j] + DP[j-coin];
           }
       }
       return DP[amount];
    }

}