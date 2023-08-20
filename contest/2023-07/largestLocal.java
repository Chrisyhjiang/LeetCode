
public class largestLocal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[][] largestLocal(int[][] grid) {
        int len = grid.length;
        int[][] res = new int[len-2][len-2];
        for(int i = 0; i < res.length; i++) {
        	for(int j = 0; j < res[0].length; j++) {
        		res[i][j] å= getMax(i, j, grid);
        	}
        }
        return res;
    }
	
	public int getMax(int i, int j, int[][] grid) {
		int max = Integer.MIN_VALUE;
		for(int a = i; a < i+3; a++) {
			for(int b = j; b < j + 3; b++) {
				max = Math.max(max, grid[a][b]);
			}
		}
		return max;
	}
}
