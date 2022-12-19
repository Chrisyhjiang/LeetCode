
public class countSubarrayFixedBounds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public long countSubarrays(int[] nums, int minK, int maxK) {
		// row zero is the most minimum element available up to this point 
		// row 1 is the the most maximum element available up to this point
		long res = 0;
		int n = nums.length;
		int[][] psa = new int[n][2];
		psa[0][0] = nums[0];
		psa[0][1] = nums[0];
		for(int i = 1; i < n; i++) {
			if(nums[i] < minK || nums[i] > maxK) { 
				psa[i][0] = nums[i];
				psa[i][1] = nums[i];
			}else {
				psa[i][0] = Math.min(psa[i-1][0], nums[i]);
				psa[i][1] = Math.max(psa[i-1][1], nums[i]);
			}
		}
		
		
		
		return res;
		
    }

}
