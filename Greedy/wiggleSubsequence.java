// https://leetcode.com/problems/wiggle-subsequence/
public class wiggleSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int wiggleMaxLength(int[] nums) {
		if(nums.length == 1) {
			return 1;
		}else if(nums.length == 2) {
			if(nums[1] != nums[0]) {
				return 2;
			}else {
				return 1;
			}
		}
		
		int count = 0;
		int cur = 1;
		while(cur < nums.length && nums[cur] == nums[cur -1]) {
			cur++;
		}
		if(cur == nums.length) {
			return 1;
		}else {
			count = 1;
			boolean bigger = !(nums[cur] > nums[cur - 1]);
			while(cur < nums.length) {
				cur = findIndex(bigger, cur, nums);
				bigger = !bigger;
				
				count++;
			}
			return count;
		}
    }
	
	public int findIndex(boolean bigger, int curIndex, int[] nums) {
		int index = curIndex + 1;
		if(bigger) {
			int max = nums[curIndex];
			while()
		}else {
			
		}
		
		return index;
	}
}
