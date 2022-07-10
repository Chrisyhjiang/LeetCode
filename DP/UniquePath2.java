
public class UniquePath2 {

	public static void main(String[] args) {
		int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
		int k = uniquePathsWithObstacles(arr);
		System.out.println(k);
	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] cache = new int[m][n];
        if(obstacleGrid[0][0] == 1) {
        	return 0;
        }else {
        	cache[0][0] = 1;
        	for(int i = 1; i < n; i++) {
            	if(obstacleGrid[0][i] == 1) {
            		cache[0][i] = 0;
            	}else {
            		cache[0][i] = cache[0][i - 1];
            	}
            }
        	for(int i = 1; i < m; i++) {
            	if(obstacleGrid[i][0] == 1) {
            		cache[i][0] = 0;
            	}else {
            		cache[i][0] = cache[i - 1][0];
            	}
            }
        }
        
        for(int i = 1; i < m; i ++) {
        	for(int j = 1; j < n; j++) {
        		if(obstacleGrid[i][j] == 1) {
        			cache[i][j] = 0;
        		}else {
        			cache[i][j] = cache[i-1][j] + cache[i][j-1];
        		}
        	}
        }
        return cache[m - 1][n - 1];        
     }
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) {
        	return 0;
        }else {
        	int m = obstacleGrid.length;
        	int n = obstacleGrid[0].length;
        	obstacleGrid[0][0] = 1;
        	for(int i = 1; i < n; i++) {
            	if(obstacleGrid[0][i] == 1) {
            		obstacleGrid[0][i] = 0;
            	}else {
            		obstacleGrid[0][i] = obstacleGrid[0][i-1];
            	}
            }
        	
        	for(int i = 1; i < m; i++) {
            	if(obstacleGrid[i][0] == 1) {
            		obstacleGrid[i][0] = 0;
            	}else {
            		obstacleGrid[i][0] = obstacleGrid[i-1][0];
            	}
            }
        	for(int i = 1; i < m; i ++) {
            	for(int j = 1; j < n; j++) {
            		if(obstacleGrid[i][j] == 1) {
            			obstacleGrid[i][j] = 0;
            		}else {
            			obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            		}
            	}
            }
        	return obstacleGrid[m-1][n-1];
        }        
     }
}
