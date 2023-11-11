class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] - i;
        }

        TreeMap<Integer, Long> map = new TreeMap<>();
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                ans = Math.max(ans, nums[i]);
            } else {
                long t = (long)(nums[i]);
                Integer f = map.floorKey(arr[i]);
                if (f != null) {
                    t += map.get(f);
                }

                while(map.ceilingKey(arr[i]) != null && map.get(map.ceilingKey(arr[i])) < t) {
                    map.remove(map.ceilingKey(arr[i]));
                }

                if (map.floorKey(arr[i]) == null || map.get(map.floorKey(arr[i])) < t) {
                    map.put(arr[i], t);
                }
                ans = Math.max(ans, t);
            }
        }
        return ans;
    }   
}