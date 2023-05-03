
public class firstPainted {

	public static void main(String[] args) {
		int[] arr = {1,4,5,2,6,3};
		int[][] mat = {{4,3,5},{1,2,6}};
		int res = firstCompleteIndex(arr, mat);
		System.out.println(res);

	}
	
	public static int firstCompleteIndex(int[] arr, int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] tbl = new int[m * n + 1][2];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				tbl[mat[i][j]][0] = i;
				tbl[mat[i][j]][1] = j;
			}
		}
		
		int[] rowspainted = new int[m];
		int[] colspainted = new int[n];
		for(int i = 0; i < arr.length; i++) {
			int row = tbl[arr[i]][0];
			int col = tbl[arr[i]][1];
			rowspainted[row]++;
			colspainted[col]++;
			if(rowspainted[row] == n || colspainted[col] == m) {
				return i;
			}
		}
		return -1;
    }

}
