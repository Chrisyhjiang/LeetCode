import java.util.*;
public class searchInRotatedArray {

	public static void main(String[] args) {
		int[] nums = {3,1,2,2,2};
		boolean b = search(nums, 1);
		System.out.println(b);

	}
	
	public static boolean search(int[] nums, int target) {
		int index = binSearch(nums, 0, nums.length - 1, target);
		if(index == -1) {
			return false;
		}else {
			return true;
		}
    }
	
	public static int binSearch(int[] nums, int start, int end, int target) {
		if(start <= end) {
			int mid = (start + end) / 2;
			if(nums[mid] == target) {
				return mid;
			}else {
				if(nums[mid] < nums[start]) {
					if(target >= nums[start] || target <= nums[mid]) {
						return binSearch(nums, start, mid -1, target);
					}else {
						return binSearch(nums, mid + 1, end, target);
					}
				}else if (nums[mid] == nums[start]) {
					int k = binSearch(nums, mid + 1, end, target);
					if(k != -1) {
						return k;
					}
					int m = binSearch(nums, start, mid - 1, target);
					if(m != -1) {
						return m;
					}
				}else {
					if(target >= nums[start] && target <= nums[mid]) {
						return binSearch(nums, start, mid - 1, target);
					}else {
						return binSearch(nums, mid + 1, end, target);
					}
				}
			}
		}
		return -1;
	}
}
