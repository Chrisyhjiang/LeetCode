class Solution {
    Integer[][] DP;
    int n, left, right, mod;
    public int countSubMultisets(List<Integer> nums, int l, int r) {
        mod = (int)(1e9 + 7);
        left = l;
        right = r;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num: nums) {
            if (num <= right) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }
        }
        n = hm.size();
        int[][] countArr = new int[n][2];
        int idx = 0;
        for (int k: hm.keySet()) {
            countArr[idx][0] = k;
            countArr[idx][1] = hm.get(k);
            idx++;
        }

        DP = new Integer[n + 1][r + 1];
        return ways(countArr, 0, 0) % mod;
    }
    // bounded Knapsack 
    public int ways(int[][] countArr, int idx, int sum) {
        if (sum > right) {
            return 0;
        }

        if (idx == n) {
            if (sum >= left  && sum <= right) {
                return 1;
            }
            return 0;
        }

        if (DP[idx][sum] != null) {
            return DP[idx][sum];
        }
        
        int res = 0;
        int curNum = countArr[idx][0];
        int curCount = countArr[idx][1];
        int curSum = sum;
        // 
        for (int i = 0; i <= curCount; i++) {
            res = (res + ways(countArr, idx + 1, curSum)) % mod;
            curSum += curNum;
        }
        DP[idx][sum] = res;
        return res;
    }
}