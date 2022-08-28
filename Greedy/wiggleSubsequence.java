// https://leetcode.com/problems/wiggle-subsequence/
public class wiggleSubsequence {

	public static void main(String[] args) {
		int[] nums = {1, 17, 16, 10, 12, 11, 13, 5};
		int ans = wiggleMaxLength(nums);
		System.out.println(ans);
	}
	
	public static int wiggleMaxLength(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
            
        int prevdiff = nums[1] - nums[0];
        int count;
        if(prevdiff != 0) {
        	count = 2;
        }else {
        	count = 1;
        }
        // find a wiggle as long as there is a wiggle, we can increment one to the sequence. 
        // between when prediff is updated 2 times, indicates that there exists at least once time
        // where there is a wiggle, the actual position does not really matter?
        
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                count++;
                prevdiff = diff;
            }
        }
        return count;
    }
	
	
}
