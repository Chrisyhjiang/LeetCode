// https://leetcode.com/problems/minimum-seconds-to-equalize-a-circular-array/description/
class Solution {
    public int minimumSeconds(List<Integer> nums) {
        // this questions involves finding the minmum maximum distance between each occurences of the same number. 
        int len = nums.size();
        HashMap<Integer, Integer> lastOccurence = new HashMap<>();
        HashMap<Integer, Integer> firstOccurence = new HashMap<>();
        HashMap<Integer, Integer> minDiff = new HashMap<>();
        
        for (int i = 0; i < nums.size(); i++) {
            int key = nums.get(i);
            if (!firstOccurence.containsKey(key)) {
                firstOccurence.put(key, i);
                minDiff.put(key, 0);
            } else {
                minDiff.put(key, Math.max(minDiff.get(key), i - lastOccurence.get(key)));
            }
            lastOccurence.put(key, i);
        }
        int min = Integer.MAX_VALUE;
        for (int key: lastOccurence.keySet()) {
            minDiff.put(key, Math.max(minDiff.get(key), 
            len - (lastOccurence.get(key) - firstOccurence.get(key))));
        }
        for (int key: minDiff.keySet()) {
            min = Math.min(min, minDiff.get(key));
        }
        return min / 2;
    }
}

