class Solution {
    public long maxArrayValue(int[] nums) {
        // the arrays add up to the same value.
        // loop from right to left n - 2 to 0
        // and compare 
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        long cur = nums[n-1];
        long greatest = 0L;
        // track i + 1 ? 
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= cur) {
                cur += (long)(nums[i]);
            } else {
                cur = (long)nums[i];
            }
            greatest = Math.max(greatest, cur);
        }
        
        return greatest;
    }
}

// 