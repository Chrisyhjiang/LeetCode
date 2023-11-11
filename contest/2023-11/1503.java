class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int k: left) {
            ans = Math.max(ans, k);
        }
        

        for (int l: right) {
            ans = Math.max(n - l, ans);
        }

        return ans;
        // stack solution?
        // how much time at most 2 * n;
        // if I just 

        // simulate the problem

        // 1 second, every time a collision happens switch direction
        // // every time there is a collision, we swap?

        // 1, 2
        // 4, 3
        
        // 2, 3
        // 3, 2

        // 1, 4
        // 4, 1

    }
}