
public class slidingSubarrBeauty {
	
	public int[] getSubarrayBeauty(int[] nums, int k, int x) {
		// two pointer with a frequency table to keep track. 
		int n = nums.length;
		int[] res = new int[n - k + 1];
		int[] freq = new int[51];
		int j = 0;
		int idx = 0;
		for(int i = 0; i < n; i++) {
			// frequency table to keep track of the negatives 
			if (nums[i] < 0) {
				freq[Math.abs(nums[i])]++;
			}
			// the left pointer is j, the right pointer is i. 
			// everytime the gap is greater than or equal to k we can check. 
			if (i - j + 1 >= k) {
				int cnt = 0; 
				// counts the thing from smallest to largest because -50 is smallest number. 
				for(int m = 50; m >= 0; m--) {
					cnt += freq[m];
					if (cnt >= x) {
						res[idx] = -1 * m;
						idx ++;
					}
				}
				if (cnt < x) {
					res[idx] = 0;
				}
				// shifts the left pointer. 
				if (nums[j] < 0) {
					freq[-1 * nums[j]]--;
					j++;
				}
				
			}
		}
		
		return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
