// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
import java.util.*;
public class TwoSumSorted {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] arr= twoSum2(nums, target);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
 		for(int i = 0; i < numbers.length - 1; i++) {
 			int start = i + 1;
 			int end = numbers.length - 1; 
 			int a = binSearch(start, end, target - numbers[i], numbers);
 			if(a != -1) {
 				res[0] = i + 1;
 				res[1] = a + 1;
 			}
		}
 		
 		return res;
    }

	public static int binSearch(int left, int right, int target, int[] arr) {
		if(left > right) {
			return -1; 
		}else {
			int mid = (left + right) / 2;
			if(arr[mid] == target) {
				return mid;
			}else if (arr[mid] < target) {
				return binSearch(mid + 1, right, target, arr);
			}else {
				return binSearch(left, mid - 1, target, arr);
			}
		}
	}
	public static int[] twoSum2(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;
		int[] res = new int[2];
		while(left < right) {
			int sum = numbers[left] + numbers[right];
			if(sum == target) {
				res[0] = left + 1;
				res[1] = right + 1;
				break;
			}else if (sum < target) {
				left ++;
			}else {
				right --;
			}
		}
		return res;
    }
	
	
}
