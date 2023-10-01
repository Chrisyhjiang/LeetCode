class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
        int idx = 0;
        int total = 0;
        int minLen = Integer.MAX_VALUE;
        for (int a: nums) {
            total += a;
        }
        // since we can shift the start we can just use mod to optimize 
        int x = target / total * nums.length;
        target %= total;

        if (target == 0) {
            return x;
        }
        int cur = 0;
        hm.put(0, -1);
        // track previous sums, we can use hashmap to track a psa against its index and update the minimum result every time. 
        for (int i = 0; i < 2 * nums.length; i++) {
            cur += nums[i % nums.length];
            if (hm.containsKey(cur - target)) {
                minLen = Math.min(minLen, i - hm.get(cur - target));
            }
            hm.put(cur, i);
        }
        if (minLen == Integer.MAX_VALUE) {
            minLen =  -1;
        } else {
            minLen += x;
        }
        return minLen;
    }
}