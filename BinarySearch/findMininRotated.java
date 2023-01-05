// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class findMininRotated {

	public static void main(String[] args) {
		int[] arr = {5,1,2,3,4};
		int res = findMin(arr);
		System.out.println(res);

	}
	
	public static int findMin(int[] nums) {
		int n = nums.length;
		if(n == 1) {
			return nums[0];
		}
		
		int start = 0;
		int end = n - 1;
		// the special case that breaks the algorithm, is that if the arr is already sorted
		// this is if the array is not rotated. 
		if(nums[end] > nums[0]) {
			return nums[0];
		}
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(nums[mid + 1] < nums[mid]) {
				return nums[mid + 1];
			} 
			if(nums[mid - 1] > nums[mid]) {
				return nums[mid];
			}
			// if the inflection point is on the the left, then mid has to be smaller than the first. number
			// look at peak behavior on a graph to understand
			if(nums[mid] > nums[0]) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return nums[start];
		
    }

}
