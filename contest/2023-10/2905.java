class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int maxIdx = 0;
        int minIdx = 0;
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        for (int j = indexDifference; j < nums.length; j++) {
            int i = j - indexDifference;
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (Math.abs(nums[j] - nums[maxIdx]) >= valueDifference) {
                res[0] = maxIdx;
                res[1] = j;
                break;
            }

            if (Math.abs(nums[j] - nums[minIdx]) >= valueDifference) {
                res[0] = minIdx;
                res[1] = j;
                break;
            }
        }
        return res;
    }
}