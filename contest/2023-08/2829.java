// https://leetcode.com/problems/determine-the-minimum-sum-of-a-k-avoiding-array/
class Solution {
    public int minimumSum(int n, int k) {
        int sum = 0;
        int num = 1;
        for (int i = 0; i < n; i++) {
                if (num > 1 && k > num && k < 2 * num) {
                    num = k;
                }
                sum += num;
                num++;
        }

        return sum;
    }
}


