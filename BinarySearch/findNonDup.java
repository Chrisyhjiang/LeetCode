// https://leetcode.com/problems/single-element-in-a-sorted-array/description/
public class findNonDup {
	
	public static void main(String[] args) {
		int[] arr = {1,1,2};
		int res = singleNonDuplicate(arr);
		System.out.println(res);
	}
	
	
	public static int singleNonDuplicate(int[] nums) {
		int start = 0;
		int n = nums.length;
		int end = n - 1;
		/*
		 * starting array is always odd length
		 * therefore if we remove a pair in the middle of nums
		 * we can conlude that the part with the odd length 
		 * would be where the non duplicate exists
		 */
		while(start < end) {
			int mid = (start + end) / 2;
			int l = nums[mid - 1];
			int r = nums[mid + 1];
			boolean evenHalf = end - mid % 2 == 0;
			if(r == nums[mid]) {
				if(evenHalf) {
					start = mid + 2;
				}else {
					end = mid -1;
				}
			}else if(l == mid) {
				if(evenHalf) {
					end = mid - 2;
				}else {
					start = mid + 1;
				}
			}else {
				return nums[mid];
			}
			
		}
		return nums[start];
    }
}
