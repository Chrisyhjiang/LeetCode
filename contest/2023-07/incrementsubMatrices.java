
public class incrementsubMatrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
	
	public int[][] rangeAddQueries(int n, int[][] queries) {
		int[][] mat = new int[n][n];
		int[][] psa = new int[n + 1][n + 1];
		
		
		for(int[] q: queries) {
			int r1 = q[0];
			int c1 = q[1];
			int r2 = q[2];
			int c2 = q[3];
			
			psa[r1][c1] += 1;
			psa[r2 + 1][c2 + 1] += 1;
			psa[r1][c2 + 1] -= 1;
			psa[r2 + 1][c1] -= 1;
		}
		
		
		for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                psa[i][j+1] += psa[i][j];
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
            	psa[i+1][j] += psa[i][j];
                mat[i][j] = psa[i][j];
            }
        }
        return mat;
    }




}
