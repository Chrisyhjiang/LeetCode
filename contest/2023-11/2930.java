class Solution {
    public int stringCount(int n) {
        long cnt = 0; 
        int mod = (int)(1e9 + 7);
        
        return (int)(((+ pow(26, n , mod) - (n + 75 ) * pow(25, n - 1, mod) + (2 * n + 72) * pow(24, n - 1, mod) - (n + 23) * pow(23, n - 1, mod)) % mod + mod) % mod);
        
        
    }

    public long pow(long x, long n, long mod) {
        long res = 1;
        long p  = x % mod;
        while (n != 0) {
            if ((n & 1) != 0) {
                res = (res * p) % mod; 
            }

            p = (p * p) % mod;
            n >>= 1;
        }
        return res;
    }

    
}