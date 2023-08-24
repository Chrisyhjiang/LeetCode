// https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/description/
class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        for (int i = x; i < nums.size(); i++) {
            int e = nums.get(i);
            tm.put(e, tm.getOrDefault(e, 0) + 1);
        }
        int n = nums.size();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - x; i++) {
            int k = nums.get(i);
            // gets smallest key greater or equal to than current key. 
            Integer a = tm.ceilingKey(k);
            // gets largest key smaller than or equal to the current key. 
            Integer b = tm.floorKey(k);
            int cDiff = Integer.MAX_VALUE;
            int fDiff = Integer.MAX_VALUE;
            // cannot find ceilingKey
            if (a != null) {
                cDiff = Math.abs(a - k);
            }
            // cannot find floorKey
            if (b != null) {
                fDiff = Math.abs(b - k);
            }
            
            // sliding window concept
            res = Math.min(res, Math.min(cDiff, fDiff));
            int key = nums.get(x + i);
            if (tm.get(key) == 1) {
                tm.remove(key);
            } else {
                tm.put(key, tm.get(key) - 1);
            }
        }

        return res;
    }
}
