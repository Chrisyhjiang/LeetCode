// https://leetcode.com/problems/number-of-islands/
public class numIslands {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int numIslands(char[][] grid) {
        if(grid == null||grid.length == 0){
            return 0;
        }
		int res = 0;
		int m = grid.length;
		int n = grid[0].length;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == '1') {
					res++;
					DFS(i, j, grid);
				}
			}
		}
		return res;
    }
	
	public static void DFS(int i, int j, char[][]grid) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		DFS(i+1,j,grid);
		DFS(i-1,j,grid);
		DFS(i,j+1,grid);
		DFS(i,j-1,grid);
	}
}
