// https://leetcode.com/problems/range-sum-query-2d-immutable/
public class rangeQuery {
	static int[][] psa; 
	public rangeQuery(int[][] matrix) {
        psa = new int[matrix.length][matrix[0].length];
        psa[0][0] = matrix[0][0]; 
        for(int i = 1; i < matrix[0].length; i++) {
        	psa[0][i] = psa[0][i-1] + matrix[0][i];
        }
        for(int i = 1; i < matrix.length; i++) {
        	psa[i][0] = psa[i-1][0] + matrix[i][0];
        }
        for(int i = 1; i < matrix.length; i++) {
        	for(int j = 1; j < matrix[0].length; j++) {
        		psa[i][j] = psa[i][j-1] + psa[i-1][j] - psa[i-1][j-1] + matrix[i][j]; 
        	}
        }
        
        
    }
    
    public static int sumRegion(int row1, int col1, int row2, int col2) {
    	if(row1 == 0 && col1 == 0) {
        	return psa[row2][col2];
        }else if (row1 == 0) {
        	return psa[row2][col2] - psa[row2][col1-1];
        }else if (col1 == 0) {
        	return psa[row2][col2] - psa[row1-1][col2];
        }else {
        	return psa[row2][col2] - psa[row1-1][col2] - psa[row2][col1-1] + psa[row1-1][col1-1];
        }
    }
	
	
	public static void main(String[] args) {
		int[][] arr = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
		rangeQuery rq = new rangeQuery(arr);
		int res1 = sumRegion(2,1,4,3);
		int res2 = sumRegion(1,1,2,2);
		int res3 = sumRegion(1,2,2,4);
		
	}

}
