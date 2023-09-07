// https://leetcode.com/problems/maximum-sum-of-almost-unique-subarray/
class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        // sliding windown hashmap to track size. 
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int n = nums.size();
        long sum = 0L;
        long maxSum = 0L;
        
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                hm.put(nums.get(i), hm.getOrDefault(nums.get(i), 0) + 1);
                sum += nums.get(i);
            } else {
                int left = nums.get(i);
                sum += left;
                 hm.put(left, hm.getOrDefault(left, 0) + 1);
                 if (hm.size() >= m) {
                     maxSum = Math.max(maxSum, sum);
                 }
                 int right = nums.get(i-k+1);
                 sum -= right;
                 hm.put(right, hm.getOrDefault(right, 1) - 1);
                 if (hm.get(right) == 0) {
                     hm.remove(right);
                 }
            }
        }
        return maxSum;
    }
}