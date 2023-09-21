class Solution {
    public int countWays(List<Integer> nums) {
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        for (int e: nums) {
            tm.put(e, tm.getOrDefault(e, 0) + 1);
        }
        
        int totalPrev = 0;
        int res = 1;
        for (Integer key: tm.keySet()) {
        	if (totalPrev >= key) {
        		res--;
        	}
        	totalPrev +=  tm.get(key);
        	if (totalPrev > key) {
        		res++;
        	}
        }
        
        return res;
    }
}