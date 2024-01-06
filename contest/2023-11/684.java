

class Solution {
    public class DSU{
        int size[];
        int parent[];

        public DSU(int n) {
            size = new int[n+1];
            parent = new int[n+1];

            for (int i = 1; i <= n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }
        public int findParent(int node) {
            if (node == parent[node]) {
                return node;
            }

            return parent[node] = findParent(parent[node]);
        }

        public void union(int u, int v) {
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);

            if (ulp_u == ulp_v) {
                return;
            }

            if (size[ulp_u] < size[ulp_v]) {
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            } else {
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        DSU set = new DSU(edges.length);
        int[] ans = new int[2];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (set.findParent(u) == set.findParent(v)) {
                ans[0] = u;
                ans[1] = v;
            } else {
                set.union(u, v);
            }
        }
        return ans;
    }
}