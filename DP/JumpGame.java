// https://leetcode.com/problems/jump-game/
import java.util.Arrays;


public class JumpGame {
	static int[] DP; 
	public static void main(String[] args) {
		int[] arr = {2,3,0,1,4};
		System.out.println(canJump4(arr));
	}
	
	public static boolean canJump(int[] nums) {
		DP = new int[nums.length + 5];
		Arrays.fill(DP, -1);
		boolean res = canJump2(nums, 0);
		return res;
    }
	public static boolean canJump2(int[] nums, int i) {
		boolean res = false;
		if(i >= nums.length - 1) {
			res = true;
		}else {
			if(nums[i] == 0) {
				res = false;
			}else {
				for(int j = 0; j <= nums[i]; j++) {
					if(DP[i + j] == -1) {
						res = canJump2(nums, i + j);
						if(res) {
							DP[i + j] = 1;
						}else {
							DP[i + j] = 0;
						}
					}else {
						res = DP[i + j] == 1;
					}
					if(res) {
						break;
					}
				}
			}
		}
		return res;
	}
	
	public static boolean canJump3(int[] nums) {
		// simple linear solution to keep track of the lastGoodIndex. 
		int lastGoodIndex = nums.length - 1;
		for(int i = nums.length - 1; i >= 0; i --) {
			if(i + nums[i] >= lastGoodIndex) {
				lastGoodIndex = i;
			}
		}
		return lastGoodIndex == 0;
	}
	
	public static int canJump4(int[] nums) {
		int[] DP = new int[nums.length];
		for(int i = DP.length - 2; i  >= 0; i--) {
			int steps = nums[i];
			int min = Integer.MAX_VALUE;
			for(int j = 1; j <= steps; j++) {
				if(i + j < nums.length) {
					min = Math.min(min, DP[i + j]);
				}
			}
			DP[i] = min;
			if(min != Integer.MAX_VALUE) {
				DP[i] += 1;
			}
			
		}
		return DP[0];
	}
}
