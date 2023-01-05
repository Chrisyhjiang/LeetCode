// https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/
import java.util.*;
public class topKFrequent {

	public static void main(String[] args) {

	}
	
	class Pair{
		int key; 
		int freq;
		public Pair(int k, int f) {
			key = k;
			freq = f;
		}
	}
	
	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Pair> hm = new HashMap<Integer, Pair>();
		for(int i = 0; i < nums.length; i++) {
			if(hm.containsKey(nums[i])) {
				Pair p = hm.get(nums[i]);
				p.freq++;
				hm.put(nums[i], p);
			}else {
				hm.put(nums[i], new Pair(nums[i], 1));
			}
		}
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new cmpfunc());
		for(Pair p: hm.values()) {
			pq.add(p);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		int[] res = new int[k];
		for(int i = 0; i < k; i++) {
			res[i] = pq.poll().key;
		}
		return res;
    }
	
	class cmpfunc implements Comparator<Pair>{

		@Override
		public int compare(Pair o1, Pair o2) {
			return o1.freq - o2.freq;
		}
		
	}


}
