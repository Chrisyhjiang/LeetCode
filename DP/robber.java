
public class robber {

	public static void main(String[] args) {
		int[] arr = {1,2,3,1};
		int ans = rob2(arr);
		System.out.println(ans);

	}
	public static int rob(int[] nums) {
		if(nums.length == 1) {
			return nums[0];
		}else if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}else {
			int len = nums.length;
			int[] DP = new int[len];
			DP[len - 1] = nums[len - 1];
			DP[len - 2] = nums[len - 2];
			DP[len - 3] = nums[len - 3] + DP[len - 1];
 			for(int i = len - 4; i >= 0; i--) {
				DP[i] = Math.max(DP[i + 2], DP[i + 3]) + nums[i];
			}
			
			return Math.max(DP[0], DP[1]);
		}
		
    }
	
	public static int rob2(int[] nums) {
		if(nums.length == 1) {
			return nums[0];
		}
		int[] arr1 = new int[nums.length - 1];
		int[] arr2 = new int[nums.length - 1];
		arr1[0] = nums[0];
		arr2[arr2.length - 1] = nums[nums.length - 1];
		for(int i = 1; i < nums.length - 1; i++) {
			arr1[i] = nums[i];
			arr2[i - 1] = nums[i];
		}
		int a = rob(arr1);
		int b = rob(arr2);
		return Math.max(a,b);
	}
}
