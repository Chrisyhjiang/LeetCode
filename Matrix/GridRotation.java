// https://leetcode.com/problems/cyclically-rotating-a-grid/submissions/ # 1914
public class GridRotation {

	public static void main(String[] args) {
		int[][] ans = {{1,2,3,4,17,18}, {5,6,7,8,19,20}, {9,10,11,12,21,22}, {13,14,15,16,23,24}};
		ans = rotateGrid(ans,2);
		System.out.println("hello");
	}
	
	 public static int[][] rotateGrid(int[][] grid, int k) {
		 rotateLayer(0, 0, grid.length, grid[0].length, grid, k);
		 return grid;
	 }
	 // leftmost coordinate of grid is (x,y)  row is grid width col is grid height	 
	 public static void rotateLayer(int x, int y, int row, int col, int [][] grid, int k) {

		 while (row > 0 && col > 0) {
			 int round = k % (2 * (row + col) - 4);
			 for (int j = 0; j < round; j ++) {
				 // down
				 int prev = grid[x][y];
				 for (int i = 1; i < row; i++) {
					 int temp = grid[x+i][y];
					 grid[x+i][y] = prev;
					 prev = temp;	 
				 }
				 // right
				 for (int i = 1; i < col; i++) {
					 int temp = grid[x + row -1][y+i];
					 grid[x + row - 1][y+i] = prev;
					 prev = temp;
				 }
				 // up
				 for (int i = row-2; i >= 0; i--) {
					 int temp = grid[x + i][y + col -1];
					 grid[x + i][y + col -1] = prev;
					 prev = temp;
				 }
				 // left
				 for (int i = col-2; i >= 0; i--) {
					 int temp = grid[x][y + i];
					 grid[x][y + i] = prev;
					 prev = temp;
				 } 
			 }
			 
			 row -= 2;
			 col -= 2;
			 
			 x++;
			 y++;
		 }
	 }
	 
}
