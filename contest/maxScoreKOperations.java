import java.util.*;
public class maxScoreKOperations {

	public static void main(String[] args) {
		int[] nums = {1,10,3,3,3};
		int k = 3;
		long res = maxKelements(nums, k);
		System.out.println(res);
	}
	
	public static long maxKelements(int[] nums, int k) {
		// pq solution
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int e: nums) {
			pq.add(e);
		}
		long res = 0;
		for(int i = 0; i < k; i++) {
			long n = pq.poll();
			res += n;
			pq.add((int)(n + 2) / 3);
		}
		return res;
    }
	
	
	

}
