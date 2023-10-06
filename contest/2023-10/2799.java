class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int e: nums) {
            hs.add(e);
        }
        // temporary brute force solution. 
        int target = hs.size();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> hm = new HashMap<Integer, Integer> ();
            for (int j = i; j < nums.length; j++) {
                int key = nums[j];
                hm.put(key, hm.getOrDefault(key, 0) + 1);
                if (hm.size() == target) {
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
}