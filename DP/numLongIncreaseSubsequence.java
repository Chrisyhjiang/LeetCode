
public class numLongIncreaseSubsequence {

	public static void main(String[] args) {
		int[] arr = new int[]{1,1,1,2,2,2,3,3,3};
		int res = findNumberOfLIS(arr);
		System.out.println(res);
	}
	
	public static int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		if(n == 1) {
			return 1;
		}else {
			int[][] DP = new int[n][2];
			// 0 is the length, 1 is the occurence. 
			DP[n - 1][0] = 1;
			DP[n - 1][1] = 1;
			// a lot subsequence problems requires us to work backwards. 
			for(int i = n - 2; i >= 0; i--) {
				int maxIndex = i;
				int maxCount = 0;
				for(int j = i; j < nums.length; j++) { 
					if(nums[j] > nums[i]) {
						if(DP[j][0] > DP[maxIndex][0]) {
							maxIndex = j;
							maxCount = DP[maxIndex][1];
						}else if(DP[j][0] == DP[maxIndex][0]) {
							maxCount += DP[j][1];
						}
					}
				}
				if(maxIndex == i) {
					DP[i][0] = 1;
					DP[i][1] = 1;
				}else {
					DP[i][0] = 1 + DP[maxIndex][0];
					DP[i][1] = maxCount;
				}
			}
			
			int res = 0;
			int maxLength = 0;
			for(int[] row: DP) {
				if(row[0] > maxLength) {
					res = row[1];
					maxLength = row[0];
				}else if(row[0] == maxLength) {
					res += row[1];
				}
			}
			return res;
			
		}
    }

}
