
public class longestBitwiseOperator {

	public static void main(String[] args) {
		int[] arr = {1,2,3,3,2};
		int res = longestSubarray(arr);
		System.out.println(res);
	}
	
	public static int longestSubarray(int[] nums) {
		int max = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > max) {
				max = nums[i];
			}
		}
		int longestGlobal = 0;
		int longestLocal = 0;

		if(nums[0] == max) {
			longestGlobal = 1;
			longestLocal = 1;
		}
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == max && nums[i-1] == max) {
				longestLocal++;
			}else {
				longestLocal = 1;
			}
			longestGlobal = Math.max(longestLocal, longestGlobal);
		}
		return longestGlobal;
    }

}
