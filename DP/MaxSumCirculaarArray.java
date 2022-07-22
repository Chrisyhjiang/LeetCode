
public class MaxSumCirculaarArray {

	public static void main(String[] args) {
		int[] nums = {-10,-7,9,-7,6,9,-9,-4,-8,-5};
		int ans = maxSubarraySumCircular2(nums);
		System.out.println(ans);
	}
	
	
	
	public static int maxSubarraySumCircular2(int[] nums) {
		// Minimum subarry + Maximum subarray = total sum of the array due to the wraparound property 
		int original = kadane(nums);
		int totalSum = 0;
		int max = Integer.MIN_VALUE;
		boolean allNegative = true;
		// invert the array (multiply -1) to exploit kadane's algorithm to find minimum instead of maximum. 
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] >= 0) {
				allNegative = false;
			}
			max = Math.max(max, nums[i]);
			nums[i] *= -1;
			totalSum += nums[i];
		}
		// calculates the maximum for the inverted rray, 
		int minimumSubarray = kadane(nums);
		
		if(allNegative) {
			return max;
		}else {
			// orignal is kadanes algorithm is no circular strcture, the other result has circular structure. 
			return Math.max(original, - 1 * (totalSum - minimumSubarray));
		}
	}
	
	public static int kadane(int[] nums) {
		int localMax = 0;
		int globalMax = 0;
		
		for(int i = 0; i < nums.length; i++) {
			localMax = nums[i] + Math.max(localMax, 0);
			globalMax = Math.max(localMax, globalMax);
		}
		return globalMax;
	}
	
}
