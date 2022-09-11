import java.util.Arrays;

public class search2DMatrix {
	
	public static void main(String[] args) {
		int[][] mat = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		boolean res = searchMatrix(mat, 5);
		System.out.println(res);
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i = 0; i < m; i++) {
			int[] row = matrix[i];
			if(target >= row[0] && target <= row[n-1]) {
				int index = Arrays.binarySearch(row, target);
				if(index >= 0 && index < n) {
					return true;
				}
			}
		}
		return false;
    }
	
	public static int findRow(int[][] matrix, int target) {
		int start = 0;
		int end = matrix.length - 1;
		while(start <= end) {
			int mid = end - (start + end) / 2;
			if(matrix[mid][0] == target) {
				return mid;
			}else if(matrix[mid][0] < target){
				end = mid - 1;
			}else {
				start = mid + 1;
			}		
		}
		return start;
	}

	public static boolean searchMatrx2(int[][] matrix, int target) {
		// binary search with each one starting on the diagonal
		if(matrix == null || matrix.length == 0) {
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i = 0; i < Math.min(m,n); i++) {
			// start is i,i
			boolean colFound = binSearch(matrix, i, m - 1, true, target);
			boolean rowFound = binSearch(matrix, i, n - 1, false, target);
			if(colFound || rowFound) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean binSearch(int[][] mat, int start, int end, boolean vertical, int target) {
		 while (end >= start) {
			 int mid = (start + end)/2;
			 if (vertical) { // searching a column
				 if (mat[start][mid] < target) {
					 start = mid + 1;
				 }else if (mat[start][mid] > target) {
					 end = mid - 1;
				 }else {
					 return true;
				 }
			 } else { // searching a row
				 if (mat[mid][start] < target) {
					 start = mid + 1;
				 } else if (mat[mid][start] > target) {
					 end = mid - 1;
				 } else {
					 return true;
				}
				 
			 }
		 }

		 return false;
	}

}
