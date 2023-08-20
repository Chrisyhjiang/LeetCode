// https://leetcode.com/problems/longest-nice-subarray/description/
public class longestNiceSubarray {
	
	public static void main(String[] args) {
		int[] nums = {3,1,5,11,13};
		int res = longestNiceSubarray(nums);
		System.out.println(res);
	}
	
	public static int longestNiceSubarray(int[] nums) {
		// a | b | ... | n ^ a = b | c | ... |n
		// iff a, b, c, ... n have no overlapping bits
		int n = nums.length;
		int maxlen = 0;
		int left = 0;
		int bitmask = 0;
		for (int i = 0; i < n; i++) {
			while ((bitmask & nums[i]) != 0) {
				bitmask ^= nums[left];
				left++;
			}
			bitmask |= nums[i];
			maxlen = Math.max(maxlen, i - left + 1);
		}
		
		return maxlen;
    }
}
