// https://leetcode.com/problems/maximum-number-of-alloys/
class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, 
    		List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int res = 0;
        for (int i = 0; i < k; i++) {
        	int cur = numAlloys(composition, stock, cost, budget, i);
        	res = Math.max(res, cur);
        }
        
    	return res;
    }
    
    // k is the machine index. 
    public int numAlloys(List<List<Integer>> composition, 
    		List<Integer> stock, List<Integer> cost, int budget, int k) {
    	// binary search for the answer?
    	int start = 0;
    	int end = Integer.MAX_VALUE;
    	
    	while(start < end) {
    		// number of metals
    		int mid = (start + end) / 2;
    		if (isPossible(mid, composition.get(k), stock, cost, budget)) {
    			start = mid + 1;
    		} else {
    			end = mid;
    		}
    		
    	}
    	return start - 1;
    }
    
    public boolean isPossible(int alloy, List<Integer> composition, 
    		List<Integer> stock, List<Integer> cost, int budget) {
    	long b = (long) budget;
    	for (int i = 0; i < composition.size(); i++) {
            // overflow common issue. 
			long l = (long)alloy * composition.get(i) - stock.get(i);
    		long metalCount = Math.max(0, l);
    		if (b < metalCount * cost.get(i)) {
					return false;
				} else {
					b -= metalCount * cost.get(i);
				}
    	}
    	return true;
    }
}