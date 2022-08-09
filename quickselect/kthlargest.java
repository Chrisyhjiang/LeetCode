import java.util.*;
public class kthlargest {

	public static void main(String[] args) {
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int res = findKthLargest(nums,4);
		System.out.println(res);
	}
	
	public static int findKthLargest(int[] nums, int k) {
		 PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		 for(int i = 0; i < nums.length; i++) {
			 pq.add(nums[i]);
			 if(pq.size() > k) {
				 pq.poll();
			 }
		 }
		 return pq.peek();
        
    }

}
