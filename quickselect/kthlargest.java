import java.util.*;
public class kthlargest {

	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int res = findKthLargest2(nums,2);
		System.out.println(res);
	}
	
//	public static int findKthLargest(int[] nums, int k) {
//		 PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//		 for(int i = 0; i < nums.length; i++) {
//			 pq.add(nums[i]);
//			 if(pq.size() > k) {
//				 pq.poll();
//			 }
//		 }
//		 return pq.peek();
//        
//    }
	
	public static int findKthLargest2(int[] nums, int k) {
		int target = nums.length - k;
		return quickSelect(0, nums.length - 1, nums, target);
	}
	// quickselect algorithm
	public static int quickSelect(int l, int r, int[] nums, int target) {
		int pivot = nums[r];
		int p = l;
		// p is a pointer that indicates the place to swap the next time there is a value smaller than the pivot
		for(int i = l; i < r; i++) {
			// if the number is smaller than or equal to the pivot 
			if(nums[i] <= pivot) {
				int temp = nums[p];
				nums[p] = nums[i];
				nums[i] = temp;
				p++;
			}
		}
		// final swap to assing the pivot value to the pivot index.
		int temp = nums[p];
		nums[p] = nums[r];
		nums[r] = temp;
		// if the target is smaller than the pivot index search on the left side of pivot index
		if(p > target) {
			return quickSelect(l, p - 1, nums, target);
		}else if (p == target) {
			// if equal return the value
			return nums[p];
		}else {
			// if the garget greater than the value, search on the right side. 
			return quickSelect(p + 1, r, nums, target);
		}
	}

}
