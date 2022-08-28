import java.util.*;

public class longestSubsequenceLimited {
	
	public static void main(String[] args) {
		int[] nums = {4,5,2,1};
		int[] queries = {3,10,21};
		int[] res = answerQueries(nums, queries);
		for(int e: res) {
			System.out.println(e);
		}
	}
	
	public static int[] answerQueries(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
        	res[i] = longestLength(nums, queries[i]);
        }
        return res;
    }
	
	public static int longestLength(int[] nums, int target) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new cmpfunc());
		int total = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > target) {
				continue;
			}else {
				total += nums[i];
				pq.add(nums[i]);
				while(total > target && pq.size() != 0) {
					total -= pq.poll();
				}
			}
		}
		return pq.size();
	}
	
	public static class cmpfunc implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
		
	}
	
}
