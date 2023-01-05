// https://leetcode.com/problems/next-permutation/description/
public class nextPermutation {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		nextPermutation(arr);

	}
	
	public static void nextPermutation(int[] nums) {
		int n = nums.length;
		int i = n - 2;
		if(n == 1) {
			return;
		}
		while(i >= 0 && nums[i] >= nums[i+1]) {
			i--;
		}
		if(i >= 0) {
			int j = nums.length - 1;
			while(nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		
		reverse(nums, i + 1);
		
    }
	
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void reverse(int[] nums, int i) {
		int start = i;
		int end = nums.length - 1;
		while(start <= end) {
			swap(nums, start, end);
			start ++;
			end --;
		}
	}
	
	
}
