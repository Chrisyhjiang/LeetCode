package LeetCode.Array;
import java.util.*;
public class Sum3 {
	
//	public List<List<Integer>> threeSum(int[] nums) {
//		List<List<Integer>> list = new ArrayList<>();
//		HashSet<String> set = new HashSet<>();
//		 
//		for (int i = 0; i < nums.length - 2; i++) {
//			for (int j = i+1; j < nums.length - 1; j++) {
//				for (int k = j+1; k < nums.length; k++) {
//					int sum = nums[i] + nums[j] + nums[k];
//					if (sum == 0) {
//						String key = getKey(nums[i], nums[j], nums[k]);
//						if (!set.contains(key)) {
//							ArrayList<Integer> temp = new ArrayList<>();
//							temp.add(nums[i]);
//							temp.add(nums[j]);
//							temp.add(nums[k]);
//							
//							list.add(temp);
//							set.add(key);
//						}
//						
//					}
//				}
//			}
//		}
//		return list;
//    }
	
	
	public static List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		// sorting makes shifting easier. 
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			// the first index loops across the array
			int l = i + 1; 
			int r = nums.length - 1;
			int target = -1 * nums[i];
			// if the number is greater than 0, all sums are greater than 0 since nums is sorted. 
			if (nums[i] > 0) {
				break;
			}else {
				// if this nums[i] is the same as the last nums[i], there is a duplicate. 
				if (i > 0 && nums[i] == nums[i-1]) {
					continue;
				}
				while (l < r) {
					// Compare right with previous right if same, there is a duplicate.
					// So we then shift the right to ignore that case. 
					if (r < nums.length - 1 && nums[r] == nums[r+1]) {
						r--;
						continue;
					}
					// Compare previous left with this left if same , there is a duplicate.
					// So we then shift the right to ignore that case. 
					if (nums[l] == nums[l-1] && l - 1 > i) {
						l++;
						continue;
					}
					int sum = nums[l] + nums[r];
				
					if (sum < target) {
						// if sum is smaller than target, left shift for the number to get bigger. 
						// no right shift because in a sorted array,
						// shifting the right would cause number to go smaller
						l++;
					}else if (sum > target) {
						// if sum is bigger than target, right shift for the number to get smaller. 
						// no left shift because in a sorted array,
						// shifting the left would cause number to go smaller

						r--;
					}else {
						// once converge, add the list of values into the final answwer. 
						// Arrays.asList is a lot faster than creating arrays and saves space. 
						list.add(Arrays.asList(nums[i], nums[l], nums[r]));
						
						
						l++; 
						r--;
					}
				}
			}
				
		}
		return list;		
	}
		
	// potential use of a hashset for sorted keys 
//	public static String getKey(int a, int b, int c) {
//		String ans = "";
//		int[] arr = new int[3];
//		arr[0] = a;
//		arr[1] = b;
//		arr[2] = c;
//		
//		Arrays.sort(arr);
//		for (int element: arr) {
//			ans += String.valueOf(element);
//		}
//		
//		return ans;
//	}
	
	public static void main(String[] args) {
		
		int[] arr = {-1,0,1,2,-1,-4};
		List<List<Integer>> a = threeSum2(arr);
		System.out.println(a);

	}

}
