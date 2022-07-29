
public class ArithmeticSlice {

	public static void main(String[] args) {
		int[] arr = {1};
		int res = numberOfArithmeticSlices(arr);
		System.out.println(res);

	}
	public static int numberOfArithmeticSlices(int[] nums) {
		int len = nums.length;
		
		if(len == 1 || len == 2) {
			return 0;
		}else if (len == 3) {
			if(nums[1] - nums[0] == nums[2] - nums[1]) {
				return 1;
			}else {
				return 0;
			}
		}else {
			int[] DP = new int[len];
			int[] diff = new int[len - 1];
			DP[0] = 0;
			DP[1] = 0;
			diff[0] = nums[1]- nums[0];
			int count = 0;
			for(int i = 2; i < nums.length; i++) {
				diff[i - 1] = nums[i] - nums[i-1];
				if(diff[i-1] == diff[i - 2]) {
					count++;
					DP[i] = count;
				}else {
					count = 0;
					DP[i] = count;
				}
			}
			int res = 0;
			for(int a: DP) {
				res += a;
			}
			return res;
		}
    }
}
