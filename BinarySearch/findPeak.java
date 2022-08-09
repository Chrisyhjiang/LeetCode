
public class findPeak {

	public static void main(String[] args) {
		int[] nums = {1};
		int k = findPeakElement(nums);
		System.out.println(k);
	}
	public static int findPeakElement(int[] nums) {
		if(nums.length == 1) {
			return 0;
		}
        return search(0, nums.length - 1, nums);
    }
	public static int search(int start, int end, int[] nums) {
		int mid = (start + (end - start) / 2);
		if(start <= end) {
			if(start == end) {
				if(isPeak(start, nums)) {
					return start;
				}else {
					return -1;
				}
			}else {
				// if mid is the greatest, check mid, then search left or right
				// if left is the greatest, search left
				// if right is the greatest search right
				int max = Math.max(nums[start], Math.max(nums[mid], nums[end]));
				if(max == nums[start]) {
					if(isPeak(start, nums)) {
						return start;
					}else{
						return search(start, mid - 1, nums);
					}
				}else if (max == nums[end]) {
					if(isPeak(end, nums)) {
						return end;
					}else {
						return search(mid + 1, end, nums);
					}
				}else {
					if(isPeak(mid, nums)) {
						return mid;
					}else {
						int k = search(start, mid-1, nums);
						if(k == -1) {
							return search(mid + 1, end, nums);
						}else {
							return k;
						}
					}
					
				}
				
			}
		}
		return -1;
		
	}
	
	public static boolean isPeak(int index, int[] nums) {
		if(index == 0) {
			return nums[index] > nums[index + 1];
		}else if (index == nums.length - 1) {
			return nums[index] > nums[index - 1];
		}else {
			return nums[index] > nums[index - 1] && nums[index] > nums[index + 1];
		}
	}
	
}
