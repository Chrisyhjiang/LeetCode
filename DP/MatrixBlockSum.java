// https://leetcode.com/problems/matrix-block-sum/
public class MatrixBlockSum {

	public static void main(String[] args) {
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] res = matrixBlockSum(mat,1);
		System.out.println();
	}
	
	public static int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] res = new int[mat.length][mat[0].length];
        for(int i = 0; i < res[0].length; i++) {
        	if(i == 0) { 
        		for(int m = 0; m <= k; m++) {
        			for(int j = 0; j <= k; j++) {
        				res[0][i] += mat[m][j];
        			}
        		}
        	}else if (i == 1) {
        		res[0][i] += res[0][i-1];
        		for(int j = Math.max(0, i -k); j <= Math.min(i+k, res.length-1); j++) {
        			if(i + k < mat[0].length) {
        				res[0][i] += mat[0][i+k];
        			}
        		}
        	}else if (i == res[0].length - 1) {
        		res[0][i] += res[0][i-1];
        		for(int j = Math.max(0, i -k); j <= Math.min(i+k, res.length-1); j++) {
        			if(i - k - 1 >= 0) {
        				res[0][i] -= mat[j-1][i-k-1];
        			}
        		}
        	}else {
        		res[0][i] += res[0][i-1];
        		for(int j = Math.max(0, i - k); j <= Math.min(i+k, res.length-1); j++) {
        			if(i + k < mat[0].length) {
        				res[0][i] += mat[j][i+k];
        			}
        			if(i - k - 1 >= 0) {
        				res[0][i] -= mat[j-1][i-k-1];
        			}
        		}
        	}
        }
        
        for(int i = 1; i < res.length; i++) {
        	for(int j = 0; j < res[0].length; j++) {
        		res[i][j] += res[i-1][j];
        		if(i == 1) {
        			for(int m = Math.max(0, j - k); m <= Math.min(j + k, res[0].length - 1); m++) {
            			if(i + k  < mat.length) {
            				res[i][j] += mat[i+k][m];
            			}
            		}
        		}else if (i == res.length - 1){
        			for(int m = Math.max(0, j - k); m <= Math.min(j + k, res[0].length - 1); m++) {
        				if(i - k - 1 >= 0) {
        					res[i][j] -= mat[i-k-1][m];
        				}
            		}
        		}else {
        			for(int m = Math.max(0, j - k); m <= Math.min(j + k, res[0].length - 1); m++) {
        				if(i - k - 1 >= 0) {
        					res[i][j] -= mat[i-k-1][m];
        				}
        				if(i + k  < mat.length) {
            				res[i][j] += mat[i+k][m];
            			}
            		}
        		}
        	}
        }
        
        return res;
    }
}
