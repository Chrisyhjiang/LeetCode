class Solution {
    public  int minGroupsForValidAssignment(int[] nums) {
		 HashMap<Integer, Integer> freq = new HashMap<>();
		 int min = Integer.MAX_VALUE;
		 for (int e: nums) {
			 freq.put(e, freq.getOrDefault(e, 0) + 1);
		 }
		 
		 for (Integer key: freq.keySet()) {
			 min = Math.min(min, freq.get(key));
		 }
		 
		 int res = Integer.MAX_VALUE;
		 for (int i = 1; i <= min; i++) {
			 int cur = 0;
			 for (Integer k: freq.keySet()) {
				 int c = calc(freq.get(k), i);
				 if (c == -1) {
					 cur = -1;
					 break;
				 }
				 cur += c;
				 
			 }
			 if (cur == -1) {
				 continue;
			 }
			 res = Math.min(res, cur);
		 }
		 
	     return res;
	 }
	 
	 // faster calculation
	 public int calc(int n, int m) {
		 int div = n / m;
		 int r = n % m;
		 	if (r > div) {
			 	return -1;
			} else {
			 	double d = (double) n / (m + 1);
			 	int c = (int)Math.ceil(d);
				return c;	 
		 	} 
	 	}
}