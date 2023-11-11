class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        for (int i = 1; i <= n; i*=10) {
            long divider = i * 10;
            res += (n / divider) * i;
            res += Math.min(Math.max(n % divider - i + 1,0), i);
        }
        return res;        
        // 1, 10, 11, 12, 13, 14, 15 16, 17, 18 19
        // 21, 31, 41, 51, 61, 71, 81, 91, 100, 101
    }
}