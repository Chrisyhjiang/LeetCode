// https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
import java.util.*;
public class validParition {
	static int[] DP;
	public static void main(String[] args) {
		int[] nums = {};
		boolean ans = validPartition2(nums);
		System.out.println(ans);
	}
	
	public static boolean validPartition(int[] nums) {
		if(nums.length == 1) {
			return false;
		}
		if(nums.length == 2) {
			return nums[0] == nums[1];
		}
		if(nums.length == 3) {
			return (nums[1] - nums[0] == 1) && (nums[2] - nums[1] == 1) || (nums[1] == nums[0] && nums[2]== nums[1]);
		}else {
			Arrays.sort(nums);
			DP = new int[nums.length];
	        int res = isValid(nums, nums.length - 1);
	        return res == 1;
		}
       
    }
	public static int isValid(int[] nums, int i) {
		if(i == 0) {
			return -1;
		}else if(i == 1) {
			if(nums[0] == nums[1]) {
				return 1;
			}else {
				return -1;
			}
			
		}else if(i == 2){
			if((nums[i] == nums[i-1] && nums[i-1] == nums[i-2]) || (nums[i] == nums[i-1] + 1 && nums[i-1] == nums[i-2] + 1)) {
				return 1;
			}else {
				return -1;
			}
		}else {
			int cur = nums[i];
			int prev = nums[i-1];
			int before = nums[i-2];
			if(cur == prev) {
				if(prev == before) {
					if(DP[i-2] == 0) {
						DP[i-2] = isValid(nums, i-2); 
					}
					if(DP[i-3] == 0) {
						DP[i-3] = isValid(nums, i-3);
					}
					
					if(DP[i-3] == 1 || DP[i-2] == 1) {
						return 1;
					}
				}else {
					if(DP[i-2] == 0) {
						DP[i-2] = isValid(nums, i-2); 
					}
					
					if(DP[i-2] == 1) {
						return 1;
					}
				}
				
			}
			if(cur == prev + 1 && prev == before + 1) {
				if(DP[i-3] == 0) {
					DP[i-3] = isValid(nums, i-3);
				}
				
				if(DP[i-3] == 1) {
					return 1;
				}
			}
			return -1;
		}
		 
	}
	public static boolean validPartition2(int[] nums) {
		int len = nums.length;
		if(len == 1) {
			return false;
		}else if(len == 2) {
			return nums[0] == nums[1];
		}else if(len == 3) {
			return (nums[1] - nums[0] == 1) && (nums[2] - nums[1] == 1) || (nums[1] == nums[0] && nums[2]== nums[1]);
		}else {
			boolean[] DP = new boolean[len];
			if(nums[1] == nums[0]) {
				if(nums[2] == nums[1]) {
					DP[2] = true;
				}
				DP[1] = true;
			}
			if(nums[1] == nums[0] + 1 && nums[2] == nums[1] + 1) {
				DP[2] = true;
			}
			for(int i = 3; i < len; i++) {
				int cur = nums[i];
				int prev = nums[i-1];
				int before = nums[i-2];
				if(cur == prev) {
					DP[i]  = DP[i] || DP[i-2];
				}
				if(cur == prev && prev == before) {
					DP[i]  = DP[i] || DP[i-3];
				}
				if(cur == prev + 1 && prev == before +1) {
					DP[i] = DP[i] || DP[i-3];
				}
			}
			return DP[len - 1];
		}	
		
	}
}
