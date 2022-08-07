import java.util.Arrays;
// binary search
public class search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length]) {
			return false;
		}else {
			boolean res = false;
			for(int i = 0; i < matrix.length; i++) {
				if(matrix[i][matrix[0].length] >= target) {
					int k = Arrays.binarySearch(matrix[i], target);
					if(k >= 0 && k < matrix[0].length) {
						return true;
					}
					break;
				}
			}
			return res;
		}
	}
}
