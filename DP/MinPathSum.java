import java.util.Arrays;

public class MinPathSum {
	static int[][] cache;
	
	public static void main(String[] args) {
		int[][] grid= {{1,3,1},{1,5,1}, {4,2,1}};
		int k = minPathSum(grid);
		System.out.println(k);
	}
	
	public static int minPathSum(int[][] grid) {
        
        cache = new int[grid.length][grid[0].length];
        cache[0][0] = grid[0][0];
        for(int i = 1; i < grid[0].length; i++) {
        	cache[0][i] = cache[0][i-1] + grid[0][i];
        }
        
        for(int i = 1; i < grid.length; i++) {
        	cache[i][0] = cache[i - 1][0] + grid[i][0];
        }
        
        for(int i = 1; i < grid.length; i ++) {
        	for(int j = 1; j < grid[0].length; j++) {
        		cache[i][j] = grid[i][j] + Math.min(cache[i-1][j], cache[i][j-1]);
        	}
        }
        return cache[grid.length - 1][grid[0].length - 1];
    }
	
	public static int DFS(int i, int j, int[][] grid) {
		// base case 1: when i and j are at the dge, that means all the runs are finished. 
		if(i == grid.length - 1 && j == grid[0].length - 1) {
			return grid[i][j];
		}
		// base case 2, this number will never be chosen so. 
		if(i == grid.length || j == grid[0].length) {
			return Integer.MAX_VALUE;
		}
		int m = 0;
		int n = 0;
		if(cache[i+1][j] != -1) {
			m = cache[i+1][j]; 
		}else {
			m = DFS(i + 1, j, grid);
			cache[i+1][j] = m;
		}
		
		if(cache[i][j + 1] != -1) {
			n = cache[i][j + 1];
		}else {
			n = DFS(i, j + 1, grid);
			cache[i][j + 1] = n;
		}
		 
		return grid[i][j] + Math.min(m, n);
	}
	
	public static int minPathSum2(int[][] grid) {
		// no new space needed to instantiate the dp matrix as it can be done in the grid itself. 
		for(int i = 1; i < grid[0].length; i++) {
			grid[0][i] += grid[0][i - 1];
		}
		for(int i = 1; i < grid.length; i++) {
			grid[i][0] += grid[i - 1][0];
		}
		for(int i = 1; i < grid.length; i ++) {
        	for(int j = 1; j < grid[0].length; j++) {
        		grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
        	}
        }
		return grid[grid.length - 1][grid[0].length - 1];
	}
}
