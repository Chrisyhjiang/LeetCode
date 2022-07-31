import java.util.Arrays;
// https://leetcode.com/problems/minimum-falling-path-sum/
public class minFallSum {

	public static void main(String[] args) {
		int[][] mat = {{2,1,3},{6,5,4},{7,8,9}};
		int res = minFallingPathSum(mat);
		System.out.println(res);
	}
	public static int minFallingPathSum(int[][] matrix) {
		int len = matrix.length;
		int[] DP = new int[len];
		int[] prev = matrix[len -1];

		for(int i = len - 2; i >=0; i--) {
			for(int j = 0; j < len; j++) {
				if(j == 0) {
					DP[j] = matrix[i][j] + Math.min(prev[j+1], prev[j]);
				}else if (j == len -1) {
					DP[j] = matrix[i][j] + Math.min(prev[j], prev[j-1]);
				}else {
					DP[j] = matrix[i][j] + Math.min(prev[j+1], Math.min(prev[j], prev[j-1]));
				}
			}
			prev = Arrays.copyOf(DP, len);
			Arrays.fill(DP, 0);
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < len; i++) {
			min = Math.min(min, prev[i]);
		}
		return min;
    }
}
