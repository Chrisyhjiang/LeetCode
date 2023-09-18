import java.util.*;
class Solution {
    public static int maxNumberOfAlloys(int n, int k, int budget, 
    		List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int res = 0;
        for (int i = 0; i < k; i++) {
        	int cur = numAlloys(composition, stock, cost, budget, i);
        	res = Math.max(res, cur);
        }
        
    	return res;
    }
    
    // k is the machine index. 
    public static int numAlloys(List<List<Integer>> composition, 
    		List<Integer> stock, List<Integer> cost, int budget, int k) {
    	// binary search for the answer?
    	int start = 0;
    	int end = 100;
    	
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
    
    public static boolean isPossible(int alloy, List<Integer> composition, 
    		List<Integer> stock, List<Integer> cost, int budget) {
    	int projected = 0;
    	for (int i = 0; i < composition.size(); i++) {
    		int metalCount = Math.max(0, alloy * composition.get(i) - stock.get(i));
    		projected += metalCount * cost.get(i);
    	}
    	return projected <= budget;
    }
    
    public static void main (String[] args) {
    	List<List<Integer>> composition = new ArrayList<List<Integer>>();
    	List<Integer> ls1 = new ArrayList<Integer>();
    	ls1.add(1);
    	ls1.add(1);
    	ls1.add(1);
    	List<Integer> ls2 = new ArrayList<Integer>();
    	ls2.add(1);
    	ls2.add(1);
    	ls2.add(10);
    	composition.add(ls1);
    	composition.add(ls2);
    	List<Integer> stock = new ArrayList<Integer>();
    	stock.add(0);
    	stock.add(0);
    	stock.add(0);
    	List<Integer> cost = new ArrayList<Integer>();
    	cost.add(1);
    	cost.add(2);
    	cost.add(3);
    	int n = 3;
    	int k = 2;
    	int budget = 15;
    	int res = maxNumberOfAlloys(n, k, budget, composition, stock, cost);
    	System.out.println(res);
    	
    }
    
}