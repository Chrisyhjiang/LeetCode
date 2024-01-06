class Solution {
    public long distributeCandies(int n, int limit) {
        // 
        long res = 0;
        int min = Math.max(n - 2 * limit, 0);
        if (limit > n) {
            limit = n;
        }
        for (int i = min; i <= limit; i++) {
            int m2 = Math.max(n - i - limit, 0);
            res += ((n - i + 1 ) - 2 * m2); 
        }

        return res;
    }
}