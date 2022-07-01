
public class FirstLastPos {

	public static void main(String[] args) {
		
		
	}
	
	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
        if(nums.length == 0) {
        	res[0] = -1;
        	res[1] = -1;
        }else {
        	res[0] = binSearch(0, nums.length - 1, target, nums, true);
        	res[1] = binSearch(0, nums.length - 1, target, nums, false);
        }
        return res;
    }
	
	public static int binSearch(int start, int end, int target, int[]nums, boolean isLeft) {
		// modified binary search, if searching left and equals keep searching left, if 
		// res = -1, then res = left. same case applies for right. 
		int res = -1;
		int mid = (start + end) / 2;
		if(start > end) {
			res = -1;
		}else {
			if(nums[mid] == target) {
				if(isLeft) {
					res = binSearch(start, mid - 1, target, nums, isLeft);
				}else {
					res = binSearch(mid + 1, end, target, nums, isLeft);
				}
				// if not found res is in the maximum positions
				if(res == -1) {
					res = mid;
				}
			}else if(nums[mid] < target) {
				res = binSearch(mid + 1, end, target, nums, isLeft);
			}else {
				res = binSearch(start, mid - 1, target, nums, isLeft);
			}
		}
		return res;
		
	}
	
	public static int binSearchRight(int start, int end, int target, int[]nums) {
		int res = -1;
		int mid = (start + end) / 2;
		if(start > end) {
			res = -1;
		}else {
			if(nums[mid] == target) {
				res = binSearchRight(mid + 1, end, target, nums);
				if(res == -1) {
					res = mid;
				}
			}else if(nums[mid] < target) {
				res = binSearchRight(mid + 1, end, target, nums);
			}else {
				res = binSearchRight(start, mid - 1, target, nums);
			}
		}
		return res;
	}
	public static int binSearchLeft(int start, int end, int target, int[]nums) {
		int res = -1;
		int mid = (start + end) / 2;
		if(start > end) {
			res = -1;
		}else {
			if(nums[mid] == target) {
				res = binSearchLeft(start, mid - 1, target, nums);
				if(res == -1) {
					res = mid;
				}
			}else if(nums[mid] < target) {
				res = binSearchLeft(mid + 1, end, target, nums);
			}else {
				res = binSearchLeft(start, mid - 1, target, nums);
			}
		}
		return res;
	}
	
	
}
