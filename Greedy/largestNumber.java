// https://leetcode.com/problems/largest-number/
import java.util.*;

public class largestNumber {
	public static void main(String[] args) {
		int[] largest = {3,30,34,5,9};
		String res = largestNumber(largest);
		System.out.println(res);
	}
	
	public static String largestNumber(int[] nums) {
		String res = "";
		String[] arr = new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
			arr[i] = Integer.toString(nums[i]);
		}
		Arrays.sort(arr, new cmpfunc());
		for(int i = arr.length - 1; i>=0; i--) {
			res += arr[i];
		}
		boolean allZeros = true;
		for(int i = 0; i < res.length(); i++) {
			if(res.charAt(i) != '0') {
				allZeros = false;
				break;
			}
		}
		if(allZeros) {
			res = "0";
		}
		return res;
    }
	// apply common sense and compare the two numbers as integers
	public static class cmpfunc implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			long first = Long.parseLong(o1 + o2);
			long second = Long.parseLong(o2 + o1);
			return (int) (first - second);
		}
	}
}
