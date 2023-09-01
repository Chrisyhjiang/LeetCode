// https://leetcode.com/problems/maximize-value-of-function-in-a-ball-passing-game/submissions/
class Solution {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        // time complexity: O(nlog k) Space complexity: O(n log k)
        int n = receiver.size();
        int m = (int)(Math.ceil(Math.log(k) / Math.log(2)) + 1);

        // total scores starting at receiver 2^idx with m steps
        long[][] scores = new long[n][m];
        // upto[i][j] is defined as starting at thrower i who they end up after 2^m steps
        int[][] upto = new int[n][m];

        // binary lifting arr[] length is log(2, k) preprocessing the array. 
        for (int i = 0; i < n; i++) {  
            scores[i][0] = receiver.get(i);
            // after 1st step, passer that starts at i after 1 step should go to receiver.get(i)
            upto[i][0] = receiver.get(i);
        }
        
        // update the DP table using binary lifting
        /*
         * for scores: to compute scores up to 8, we will calculate scores up to 4 + scores up to 4 but shifted
         * for upto: to compute the upto[i][j] we will take upto[sender][j-1]
         */
        for(int j = 1; j < scores[0].length; j++) {
            for (int i = 0; i < n; i++) {
                long prevScore = scores[i][j-1];
                int sender = upto[i][j-1];
                scores[i][j] = prevScore + scores[sender][j-1];
                upto[i][j] = upto[sender][j-1];
            }
        }
        // final calculation to find the maximum value. 
        long res = -1L;
        for (int i = 0; i < n; i++) {
            int ptr = i;
            long sum = (long)(i);
            for(int j = 0; j < m; j++) {
                // cast both left hand and right hand side of operator
                // as well as the final result as long
                long val = 1L << (j);
                if ((val & k) != 0 && (val <= k)) {
                    sum += scores[ptr][j];
                    ptr = upto[ptr][j];
                }
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
