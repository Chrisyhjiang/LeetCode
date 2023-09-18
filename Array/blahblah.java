import java.util.*;
public class blahblah {
	public static int minimumMoves(int[][] g) {
        // is this question greedy?
        // take the closest all times 
        
        Integer[] initial = new Integer[9];
        Integer[] target = {1,1,1,1,1,1,1,1,1};
        
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                initial[i * 3 + j] = g[i][j];
            }
        }
        return bfs(initial, target);
    }
    
    public static int bfs(Integer[] initial, Integer[] target) {
        Queue<Integer[]> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<String>();
        q.offer(initial);
        visited.add(Arrays.toString(initial));
        
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer[] arr = q.poll();
                if (Arrays.equals(arr, target)) {
                    return moves;
                }
                for (int j = 0; j < 9; j++) {
                    if (arr[j] > 1) {
                        List<Integer> adj = adjacentCells(j);
                        for (int e: adj) {
                            Integer[] nextState = arr.clone();
                            nextState[j]--;
                            nextState[e]++;
                            if (!visited.contains(Arrays.toString(nextState))){
                                q.offer(nextState);
                                visited.add(Arrays.toString(nextState));
                            }
                            

                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    public static List<Integer> adjacentCells(int idx) {
        List<Integer> res = new ArrayList<Integer>();
        if (idx % 3 != 0) {
            res.add(idx - 1);
        }
        if (idx % 3 != 2) {
            res.add(idx + 1);
        }

        if (idx / 3 != 0) {
            res.add(idx - 3);
        }

        if (idx / 3 != 2) {
            res.add(idx + 3);
        }
        return res;
    }
    
    public static void main (String[] args) {
    	int[][] mat = {{1,1,0},{1,1,1},{1,2,1}};
    	int res = minimumMoves(mat);
    	System.out.println(res);
    }
}
