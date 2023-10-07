class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int e: nums) {
            hs.add(e);
        }
        int target = hs.size();
        int res = 0;
        int right = 0;
        int window = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        // sliding window left and right pointer
        for (int left = 0; left < n; left++) {
            while (right < n && window < target) {
                hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
                if (hm.get(nums[right]) == 1) {
                    window++;
                }
                right++;
            }
            // update answer when correect window size. 
            if (window == target) {
                res += (n - right + 1);
            }
            hm.put(nums[left], hm.get(nums[left]) - 1);
            if (hm.get(nums[left]) == 0) {
                window--;
            }
        }
        return res;
    }
}