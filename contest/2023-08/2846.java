// https://leetcode.com/problems/minimum-edge-weight-equilibrium-queries-in-a-tree/description/
class Solution {
    List<List<int[]>> graph;
    int[] parentOf;
    int[] depth;
    int[][] wtFreq;
    int[][] parentMat;

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        // graph will keep track of both children and the weight to their children. 
        graph = new ArrayList<>();
        // parentOf tracks the parent of a node. 
        parentOf = new int[n];
        // depth tracks the depth of the node from 0
        depth = new int[n]; 
        // wt freq tracks the freq of all the weights from 0 to node
        wtFreq = new int[n][27];
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }


        populateData(0, -1, 1, new int[27]);
        parentOf[0] = 0;
        // this builds the parentMat
        parentMat = buildparentOfMatrix();

        int[] results = new int[queries.length];

        for(int q = 0; q < queries.length; q++) {
            int u = queries[q][0];
            int v = queries[q][1];
            int lowestCommon = lca(u, v);
            
            int maxFreq = 0;
            int totalFreq = 0;

            for(int wtVal = 1; wtVal <= 26; wtVal++) {
                int freqLowest = wtFreq[lowestCommon][wtVal];
                int freqU = wtFreq[u][wtVal];
                int freqV = wtFreq[v][wtVal];
                totalFreq += freqU + freqV - 2 * freqLowest;
                maxFreq = Math.max(freqU + freqV - 2 * freqLowest, maxFreq);
            }

            results[q] = totalFreq - maxFreq;
        }

        return results;
    }

    // standard lca algorithm
    public int lca(int u, int v) {
        if(depth[u] > depth[v]) {
            return lca(v, u);
        }

        int depthLevelDiff = depth[v] - depth[u];
        // equalize the depth between u and so we can adance together. 
        for(int bitPos = 0; bitPos < 31; bitPos++) {
            
            if((depthLevelDiff & (1 << bitPos)) != 0) {
                int parentV = parentMat[bitPos][v];
                v = parentV;
            }
        }
        // if these are the same, then we say that they are already the lowest common ancestor
        if(u == v) {
            return v;
        }
        

        for(int bitPos = 30; bitPos >= 0; bitPos--) {
            if(parentMat[bitPos][u] != parentMat[bitPos][v]) {
                u = parentMat[bitPos][u];
                v = parentMat[bitPos][v];
            }
        }
        // return one above the parent 
        return parentMat[0][v];
    }
    
    //populateData uses DFS to populate the level, parentOf, and wtFreq arrays 
    private void populateData(int node, int par, int level, int[] wts) {
        depth[node] = level;
        parentOf[node] = par;

        for(int i = 0; i <= 26; i++) {
            wtFreq[node][i] = wts[i];
        }

        for(int[] child : graph.get(node)) {
            if(child[0] == par) continue;

            wts[child[1]]++;
            populateData(child[0], node, level + 1, wts);
            wts[child[1]]--;
        }
    }

    // this uses binary lifting
    public int[][] buildparentOfMatrix() {
        int n = parentOf.length;
        int limit = 31;
        int[][] parMat = new int[limit][n];
        parMat[0] = parentOf;
        for(int bitPos = 1; bitPos < limit; bitPos++) {
            for(int indx = 0; indx < n; indx++) {
                int prevParent = parMat[bitPos - 1][indx];
                parMat[bitPos][indx] = parMat[bitPos - 1][prevParent];
            }
        }

        return parMat;
    }

}
