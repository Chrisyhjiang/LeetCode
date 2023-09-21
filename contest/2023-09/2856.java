class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
			HashMap<Integer, Integer> hm = new HashMap<>();
			for (int e: nums) {
				hm.put(e, hm.getOrDefault(e,0) + 1);
			}

			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

			for (Integer key: hm.keySet()) {
				pq.add(hm.get(key));
			}
			
			while(pq.size() > 1) {
				int largest = pq.poll();
				int second = pq.poll();
				largest--;
				second--;
				if (largest > 0) {
					pq.add(largest);
				}
				if (second > 0)  {
					pq.add(second);
				}
			}
			int sum = 0;
			if (!pq.isEmpty()) {
				sum += pq.poll();
			}
			return sum;
    }
}