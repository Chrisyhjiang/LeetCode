// https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
import java.util.*;

public class SearchRotatedSortedArray {
	public static int search(int[] nums, int target) {
		// search for the minimum of the array then do binary search on both the left and right
		int min = searchForMin(nums);
		if(min != 0) {
			if(nums[0] > target){
				return binSearch(min, nums.length - 1, nums, target);
			}else if(nums[0] < target) {
				return binSearch(0, min - 1, nums, target);
			}else {
				return 0;
			}	
		}else {
			return binSearch(0, nums.length - 1, nums, target);
		}
		
    }
	
	public static int searchForMin(int[] nums) {
		// find the smallest element in a rotated sorted. 
		int start = 0;
		int end = nums.length - 1;
		int result = 0;
		if(nums.length == 1) {
			result = 0;
		}else {
			while(start < end) {
				int mid = (start + end) / 2;
				// if prev num < current num then current num is the smallest. 
				if(mid != 0 && nums[mid] < nums[mid - 1]) {
					result = mid;
					break;
				}
				// if current num bigger than next num, current num is the biggest, next num is smallest. 
				if(mid != nums.length - 1 && nums[mid] > nums[mid + 1]) {
					result = mid + 1;
					break;
				}
			
				if(nums[mid] < nums[end]) {
					// if current number smaller than end number 
					// from mid to end is ascending
					// cannot contain the smallest number
					// therefore the smallest is to the left of mid. 
					end = mid - 1;
				}else if (nums[mid] > nums[start]) {
					// if current number is bigger than start
					// then from start to mid is ascending
					// therefore from start to mid does not have the smallest number
					// smallest number is at the right of mid. 
					start = mid + 1;
				}
				
			}
		}
		
		return result;
	}
	
	public static int binSearch(int left, int right, int[] arr, int target) {
		int result = -1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] == target) {
				result = mid;
				break;
			}else if (arr[mid] > target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return result;
	}
	
	public static int search2(int[] nums, int target) {
		// modified binary search
		int start = 0;
		int index = -1;
		int end = nums.length - 1;
		while(start <= end) {
			// mid is either smaller than both start and end or bigger than both start and end. 
			int mid = (start + end) / 2;
			if(nums[mid] == target) {
				index = mid;
				break;
			}
			if (nums[mid] >= nums[start]) {
				// from start to mid it is in ascending order. 
				if(target < nums[mid] && target >= nums[start]) {
					// element is in between pivot and the start so shorten end. 
					end = mid - 1;
				}else {
					// element is from mid to end as it is either larger than mid or smaller than start. 
					start = mid + 1;
				}
			}else {
				// from mid to end is ascending order. 
				if(target <= nums[end] && target > nums[mid]) {
					// if the target is bigger than mid but smaller than end
					// search between mid and end shift start
					start = mid + 1;
				}else {
					// else element is before mid as it is either smaller than mid or larger than end. 
					end = mid -1;
				}
			}
			
		}
		return index;
		
	}

	public static void main(String[] args) {
		int[] nums = {1,3};
		int k = search2(nums, 3);
		System.out.println(k);
	}

}
