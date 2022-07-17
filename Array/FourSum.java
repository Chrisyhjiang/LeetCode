// https://leetcode.com/problems/4sum/
import java.util.*;
public class FourSum {
	static List<List<Integer>> res;
	public static void main(String[] args) {
		int[] nums = {1000000000,1000000000,1000000000,1000000000};
		int target = -294967296;
		List<List<Integer>> ls = fourSum(nums, target);
		for(List<Integer> l: ls) {
			for(int e: l) {
				System.out.print(e + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		double t2 = (double) target;
		Arrays.sort(nums);
		res = new ArrayList<List<Integer>>();
		int first = 0;
		while(first < nums.length) {
			int second = first + 1;
			while(second < nums.length) {
				// rethink logic here
				if(search(t2 - nums[first]- nums[second], first, second, nums)) {
					while(second < nums.length - 1 && nums[second] == nums[second + 1]) {
						second++;
					}
				}
				second++;
			}
			while(first < nums.length - 1 && nums[first] == nums[first + 1]) {
				first++;
			}
			first++;
		}
		
		return res;
		
    }
	
	public static boolean search(double target, int i, int j, int[]nums) {
		boolean ans = false;
		int left = j + 1;
		int right = nums.length - 1;
		while(left < right) {
			double cur = nums[left] + nums[right];
			if(cur == target) {
				List<Integer> ls = new ArrayList<Integer>();
				ls.add(nums[i]);
				ls.add(nums[j]);
				ls.add(nums[left]);
				ls.add(nums[right]);
				res.add(ls);
				ans = true;
				// advance left to new number
				// advance right to new number
				
				while(left < nums.length - 1 && nums[left] == nums[left + 1]) {
					left++;
				}
				left++;
				while(right > 0 && nums[right] == nums[right - 1]) {
					right--;
				}
				right --;
			}else if(cur < target) {
				while(left < nums.length - 1 && nums[left] == nums[left + 1]) {
					left++;
				}
				left++;
			}else {
				while(right > 0 && nums[right] == nums[right - 1]) {
					right--;
				}
				right --;
			}
		}
		return ans;
	}
}
