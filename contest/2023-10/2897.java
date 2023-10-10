class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int mod = (int)(1e9 + 7);
        int len = 30;
        // bits is a collection of all the bits for all the numbers in nums. 
        int[] bits = new int[len];
        // we need to do the operation everytime there is a number bigger than something else. 
        // since x & y + x | y  = x + y
        // assuming x > y, x | y is (x + d), x & y is (y -d)
        // x^2 + y^2 vs (x + d) ^ 2 + (y - d)^2 vs x^2 + 2 *(xd - yd) + 2d^2
        // so right side always bigger meaning operation should be conducted whenever possible. 
        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            for (int j = 0; j < len; j++) {
                if (n < (1 << j)) {
                    break;
                }
                if ((n & (1 << j)) != 0) {
                    bits[len - 1 - j]++;
                }
            }
        }
        
        // we collect bits and to maximize we use a greedy approach to make each number as large as possible.
        int res = 0;
        for (int i = 0; i < k; i++) {
            int cur = 1; 
            long total = 0L;
            for (int j = len - 1; j >= 0; j--) {
                total += (bits[j] != 0) ? cur : 0;
                if (bits[j] > 0) {
                    bits[j]--;
                }
                cur *= 2;
            }
            total *= total;
            int t = (int)(total % mod);
            res += t;
            res %= mod;
        }
        return res;
    }
}

