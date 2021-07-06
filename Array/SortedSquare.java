package LeetCode.Array;

public class SortedSquare {
	public static void main(String[] args) {
		int[] arr = new int[] {-5,-4,-3,-2,-1,0,0,1,2,3,4,5,6};
		
		int[] arr2 = squareSort(arr);
		
		for(int element: arr2) {
			System.out.println(element);
		}
	}
	
	public static int[] squareSort(int[] nums) {
		int[] target = new int[nums.length];
		int i = -1;
		
		for (int k = 0; k < nums.length; k++) {
			if (nums[k] >= 0) {
				i = k;
				break;
			}
		}
		
		if (i == -1) {
			// all negative input
			i = nums.length;
		}
		
		int j = i-1;
		
		int index = 0;
		while (i < nums.length && j >= 0) {
			if (nums[i] <= Math.abs(nums[j])) {
				target[index++] = nums[i]*nums[i];
				i++;
			}else {
				target[index++] = nums[j]*nums[j];
				j--;
			}
		}
		
		if (j == -1) {
			// all positive left
			for (int k = i; k<nums.length; k++) {
				target[index++] = nums[k] * nums[k];
			}
		}else if(i >= nums.length){
			// all negative left
			for (int k = j; k >= 0; k--) {
				target[index++] = nums[k] * nums[k];
					
			}
		}
		
		return target;
	}
}
