// https://leetcode.com/problems/check-if-it-is-possible-to-split-array/
class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        // if there exists 2 contiguous numbers in teh array that add up to m
        if (nums.size() == 1 || nums.size() == 2) {
            return true;
        }
        int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) + nums.get(i + 1) >= m) {
                return true;
            }
        }
        return false;
    }
}
