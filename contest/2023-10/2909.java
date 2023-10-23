class Solution {
    public int minimumSum(int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        int[] pre = new int[n - 2];
        int min = nums[0];
        for (int i = 1; i < n - 1; i++) {
            pre[i - 1] = min;
            min = Math.min(min , nums[i]) ;
        }
        
        int[] suf = new int[n - 2];
        min = nums[n-1];
        for (int i = n - 2; i >= 1; i--) {
            suf[i - 1] = min;
            min = Math.min(min, nums[i]);
        }
        
        for (int i = 1; i < n - 1; i++) {
            if (pre[i - 1] < nums[i] && suf[i - 1] < nums[i]) {
                res = Math.min(res, nums[i] + pre[i-1] + suf[i - 1]);
            }
        }
        if (res == Integer.MAX_VALUE) {
        	return -1;
        }
        return res;
    }
}