// 
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.size();
        long cnt = 0;
        hm.put(0, 1);
        int prevRem = 0;
        for (int i = 0; i < n; i++) {
            if ((nums.get(i) % modulo) == k) {
                prevRem++;
            }
            prevRem %= modulo;
            int targetRem = (prevRem + modulo - k) % modulo;
            cnt += hm.getOrDefault(targetRem, 0);
            hm.put(prevRem, hm.getOrDefault(prevRem, 0) + 1);
        }

        return cnt;
    }

}