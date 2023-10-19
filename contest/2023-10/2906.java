class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] arr = new long[m * n];
        long total = 1L;
        int mod = 12345;
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] %= mod;
                arr[idx] = grid[i][j];
                idx++;
            }
        }

        long[] prefix = new long[m * n];
        long[] suffix = new long[m * n];
        long product = 1;
        for (int i = 0; i < m * n; i++) {
            prefix[i] = product;
            product *= arr[i];
            product %= mod;
        }
        product = 1;
        for (int i = m * n - 1; i >= 0; i--) {
            suffix[i] = product;
            product *= arr[i];
            product %= mod;
        }
        idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = (int)((prefix[idx] * suffix[idx]) % mod);
                idx++;
            }
        }

        return grid;
    }
}