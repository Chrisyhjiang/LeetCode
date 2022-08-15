import java.util.*;
public class twoSumClosest0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int closestTo0(int[] arr) {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		int minSum = Integer.MAX_VALUE;
		int minLeft = -1;
		int minRight = -1;
		while(left < right) {
			int sum = arr[left] + arr[right];
			if(Math.abs(sum) < Math.abs(minSum)) {
				minSum = sum;
				minLeft = left;
				minRight = right;
			}
			if(sum < 0) {
				left++;
			}else if (sum == 0) {
				break;
			}else {
				right --;
			}
		}
		return arr[minLeft] + arr[minRight]; 
	}
}
