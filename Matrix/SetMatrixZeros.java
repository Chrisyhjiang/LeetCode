// https://leetcode.com/problems/set-matrix-zeroes/
import java.util.*;
public class SetMatrixZeros {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
		setZeroes2(matrix);
		
	}
	
	public static void setZeroes(int[][] matrix) {
		HashSet<Integer> row = new HashSet<Integer>();
		HashSet<Integer> col = new HashSet<Integer>();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					row.add(i);
					col.add(j);
				}
			}
		}
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(row.contains(i) || col.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
		
    }
	public static void setZeroes2(int[][] matrix) {
		boolean rowZero = false;
		for(int r = 0; r < matrix.length; r++) {
			for(int c = 0; c < matrix[0].length; c++) {
				if(matrix[r][c] == 0) {
					matrix[0][c] = 0;
					if(r > 0) {
						matrix[r][0] = 0;
					}else {
						rowZero = true;
					}
					
				}
			}
		}
		for(int r = 1; r < matrix.length; r++) {
			for(int c = 1; c < matrix[0].length; c++) {
				if(matrix[r][0] == 0 || matrix[0][c] == 0) {
					matrix[r][c] = 0;
				}
			}
		}
		if(matrix[0][0] == 0) {
			for(int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
		if(rowZero) {
			Arrays.fill(matrix[0], 0);
		}
    }
	
}
