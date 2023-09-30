class Solution {
    Integer[] dp;
    public int[] minEdgeReversals(int n, int[][] edges) {
        int[] ans = new int[n];
        // dp stands for the min number of edge reversals so node u can reach every node in its subtree. 
        dp = new Integer[n];
        // graph keeps track start which is the index, and a list of ends as well as the directions.
        List<Pair<Integer, Boolean>> [] graph = new List[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            // u -> v = true, v -> u = false
            graph[u].add(new Pair(v, true));
            graph[v].add(new Pair(u, false));
        }
        ans[0] = populateDP(graph, 0, visited);
        Arrays.fill(visited, false); 
        // dfs to calculate the final answer array. 
        dfs(graph, 0, visited, ans);
        return ans;
    }
    // DP[i] by definition is the min # edge reversals needed to reach everything. 
    public int populateDP(List<Pair<Integer, Boolean>>[] graph, int u, boolean[] visited) {
        if (dp[u] != null) {
            // if already calculated, return.
            return dp[u];
        }
        int res = 0;
        visited[u] = true;
        for (Pair<Integer, Boolean> p: graph[u]) {
            int v = p.getKey();
            boolean b = p.getValue();
            // ignores previously visited nodes. 
            if (visited[v]) {
                continue;
            } else {
                visited[v] = true;
                // take sum of all edge reversals needed to complete subtree except yourself.
                res += populateDP(graph, v, visited) + (b ? 0 : 1);
            }
        }
        dp[u] = res;
        return dp[u];
    }
    
    // calculates based on the subtree information. 
    public void dfs(List<Pair<Integer, Boolean>>[] graph, int u, boolean[] visited, int[] ans) {
        visited[u] = true;
        
        for (Pair<Integer, Boolean> p: graph[u]) {
            int v = p.getKey();
            boolean b = p.getValue();
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            ans[v] = ans[u] + (b ? 1 : -1);
            dfs(graph, v, visited, ans);
        }
    }

}