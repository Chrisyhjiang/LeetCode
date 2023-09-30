class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int max = -1;
        int prev = -1;
        while (right < nums.length) {
            if (nums[right] == 0) {
                if (prev != -1) {
                    max = Math.max(max, right - left - 1);
                    left = prev + 1;
                }
                prev = right;
                
            }
            right++;
        }
        max = Math.max(max, right - left - 1);
        return max;
    }

}