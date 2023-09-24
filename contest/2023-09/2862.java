class Solution {
    public long maximumSum(List<Integer> nums) {
        int n = nums.size();
        long res = 0L;

        for (int i = 1; i <= n; i++)    {
            long cur = 0;
            for (int j = 1; j * j * i <= n; j++) {
                cur += nums.get(j * j * i - 1);
            }
            res = Math.max(cur, res);
        }
        return res;
    }
}

