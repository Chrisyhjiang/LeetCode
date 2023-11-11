class Solution {
    int[] res;
    int[] cnt;
    ArrayList[] g;
    int N;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        res = new int[n];
        cnt = new int[n];
        N = n;
        Arrays.fill(cnt,1);

        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for (int[] edge: edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }

        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }
    

    public void dfs(int node, int parent) {
        ArrayList<Integer> children = g[node];
        for (int child: children) {
            // checks if this is the leaf node or next node is the parent
            if (child != parent) {
                dfs(child, node);
                cnt[node] += cnt[child];
                res[node] += res[child] + cnt[child];
            }
        }
    }

    public void dfs2(int node, int parent) {
        ArrayList<Integer> children = g[node];
        for (int child: children) {
            if (child != parent) {
                res[child] = res[node] - cnt[child] + N - cnt[child];
                dfs2(child, node);
            }
        }
    }
}