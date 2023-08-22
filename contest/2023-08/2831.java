// https://leetcode.com/problems/find-the-longest-equal-subarray/description/
class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {


        int start = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int maxFreq = 0;
        for (int end = 0; end < nums.size(); end++) {
            freq.put(nums.get(end), freq.getOrDefault(nums.get(end), 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(nums.get(end)));
            while ((end - start + 1) - maxFreq > k) {
                freq.put(nums.get(start), freq.get(nums.get(start) - 1));
                start++;
            }
        }

        return maxFreq;
    }
}