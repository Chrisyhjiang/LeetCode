import java.util.*;

// https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
public class kDiffPairs {

	public static void main(String[] args) {
		int[] arr = {1,3,1,5,4};
		int k = 0;
		int res = findPairs(arr, k);
		System.out.println(res);

	}
	
	public static int findPairs(int[] nums, int k) {
		int n = nums.length;
		Arrays.sort(nums);
		int res = 0;
		for(int i = 0; i < n; i++) {
			if(i == 0 || nums[i] != nums[i-1]) {
				res+= (search(i+1, n - 1, k + nums[i], nums))? 1: 0;
			}
		}
		return res;
    }
	
	public static boolean search(int start, int end, int target, int[]arr) {
		while(start <= end) {
			int mid = end - (end - start) / 2;
			if(arr[mid] == target) {
				return true;
			}else if(arr[mid] < target) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return false;
	}
	

}
