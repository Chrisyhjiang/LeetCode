
public class equalRowColumn {

	public static void main(String[] args) {
		int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
		int ans = equalPairs(grid);
		System.out.println(ans);
	}
	
	public static int equalPairs(int[][] grid) {
		int res = 0;
		for(int i = 0; i < grid.length; i++) {
			int[] first = grid[i];
			for(int j = 0; j < grid[0].length; j++) {
				// j is column;
				boolean isEqual = true;
				for(int k = 0; k < first.length; k++) {
					if(first[k] != grid[k][j]) {
						isEqual = false;
						break;
					}
				}
				if(isEqual) {
					res++;
				}
			}
			
		}
		
		return res;
    }

}
