class Solution {

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        
        Queue<int[] > q = new LinkedList<int[]>();
        int n = grid.size();  
        if (grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) {
            return 0;
        }
        // adds the thief locations to the queue. 
        int[] dir = {1, 0, -1, 0, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    int[] arr = {i, j};
                    q.add(arr);
                }
            }
        }
        // does BFS to update the grid in place. note the distance is 1+ the actual distance
        while(!q.isEmpty()) {
            int[] point = q.remove();
            int i = point[0];
            int j = point[1];
            int val = grid.get(i).get(j);
            for (int d = 0; d < 4; d++) {
                int x = i + dir[d];
                int y = j + dir[d+1];
                if (Math.min(x, y) >= 0 && Math.max(x, y) < n) {
                    if (grid.get(x).get(y) == 0) {
                        grid.get(x).set(y, val + 1);
                        int[] arr = {x,y};
                        q.add(arr);
                    } else {
                        grid.get(x).set(y, Math.min(grid.get(x).get(y), val + 1));
                    }
                }
            }
        }
        // binary search for the possible answer as search space can be from 0 -> n. 
        int start = 0;
        int end = n;
        while (start <= end) {
            int mid = (start + end) / 2;
            boolean[][] visited = new boolean[n][n];
            if (isPossible(grid, visited, mid, 0, 0, n)) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return end - 1;

    }
    // DFS to check if the path is viable
    public static boolean isPossible(List<List<Integer>> grid, 
                                boolean[][] visited, int mid, int i, int j, int n) {
        if(i < 0 || j < 0 ||i >= n || j >= n || visited[i][j] || grid.get(i).get(j) < mid) {
            return false;
        }
        if (i == n - 1 && j == n - 1) {
            return grid.get(i).get(j) >= mid;
        }
        visited[i][j] = true;

        return isPossible(grid, visited, mid, i + 1, j, n) ||
                isPossible(grid, visited, mid, i - 1, j, n) ||
                isPossible(grid, visited, mid, i, j + 1, n) ||
                isPossible(grid, visited, mid, i, j - 1, n);

    }
}
