// https://leetcode.com/problems/maximal-square/
public class MaximalSquare {

	public static void main(String[] args) {
		char[][] mat = {{'1','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'1','1','1','1','1'}, {'0','0','1','1','1'}};
		int res = maximalSquare(mat);
		System.out.println(res);
	}
	
	public static int maximalSquare(char[][] matrix) {
		// the cache is the largest square with all ones with the right bottom corner as 1.
        int[][] isSquare = new int[matrix.length + 1][matrix[0].length + 1];
        int maxSide = -1;
        for(int i = 0; i < matrix.length; i++) {
        	isSquare[i][isSquare[0].length - 1] =  0;
        }
        for(int i = 0; i < matrix[0].length; i++) {
        	isSquare[isSquare.length - 1][i] =  0;
        }
       
        for(int i = 1; i <= matrix.length; i++) {
        	for(int j = 1; j <= matrix[0].length; j++) {
        		if(matrix[i-1][j-1] == '1') {
        			// i,j  	i,j-1		i-1 j are the three limiting factors of i,j
        			isSquare[i][j] = Math.min(isSquare[i-1][j-1], Math.min(isSquare[i-1][j], isSquare[i][j-1])) + 1;
        		}
        		maxSide = Math.max(maxSide, isSquare[i][j]);
        	}
        }
        return maxSide * maxSide;
    }
}
