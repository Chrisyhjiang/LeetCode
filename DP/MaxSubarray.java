public class MaxSubarray {
	public static int maxSubArray(int[] nums) {
		// DP kadadne's algorithm. Assign Curmax 0 when it is less than 0 as 
		// only positives should be kept. 
        int globalMax = Integer.MIN_VALUE;
        int curMax = 0;
        for(int num: nums) {
        	curMax += num;
        	globalMax = Math.max(curMax, globalMax);
        	if(curMax < 0) {
        		curMax = 0;
        	}
        }
        
        
        return globalMax;
    }
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
}
