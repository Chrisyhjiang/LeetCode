// https://leetcode.com/problems/minimum-operations-to-form-subsequence-with-target-sum/description/
class Solution {
    public int minOperations(List<Integer> nums, int target) {
        int[] numsFreq = new int[31];
        for(int e: nums) {
            int idx = (int) (Math.log(e) / Math.log(2));
            numsFreq[idx]++;
        }
        int res = 0;
        long carry = 0;
        for (int i = 0; i < numsFreq.length; i++) {
            // if ith bit of target == 0
            // carry the number
            if ((target & (1 << i)) == 0) {
                carry += numsFreq[i] * (1 << i);
                continue; 
            } 
            // if ith bit of target is not 0 and ith bit of Numfreq is greater than 0
            if (numsFreq[i] > 0) {
                numsFreq[i]--;
                carry += numsFreq[i] * (1 << i);
                continue;
            }
            // if the ith bit of target is not 0 but numFreq is 0. 

            if (carry >= (1 << i)) {
                carry -= (1 << i);
                continue;
            } 
            
            boolean found = false;
            for (int j = i + 1; j < numsFreq.length; j++) {
                if (numsFreq[j] == 0) {
                    continue;
                }
                found = true;
                for (int k = j; k > i; k--) {
                    numsFreq[k]--;
                    numsFreq[k-1] += 2;
                    res++;
                }
                break;
            }
            if (!found) {
                return -1;
            }
            i--;
        }
        return res;
    }
}

