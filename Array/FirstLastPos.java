
public class FirstLastPos {

	public static void main(String[] args) {
		int[] arr = {2,2};
		int[] res = searchRange(arr, 2);
		for(int a: res) {
			System.out.println(a);
		}
	}
	
	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
        if(nums.length == 0) {
        	res[0] = -1;
        	res[1] = -1;
        }else {
        	res[0] = binSearchLeft(0, nums.length - 1, target, nums);
        	res[1] = binSearchRight(0, nums.length - 1, target, nums);
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
				if(mid < nums.length - 1) {
					if(nums[mid + 1] != target) {
						res = mid;
					}else {
						res = binSearchRight(mid + 1, end, target, nums);
					}
				}else {
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
				if(mid > 0) {
					if(nums[mid - 1] != target) {
						res = mid;
					}else {
						res = binSearchLeft(start, mid - 1, target, nums);
					}
				}else {
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
