class Graph {
    List<List<int[]>> g;
    public Graph(int n, int[][] edges) {
        g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        int[] arr = {edge[1], edge[2]};
        g.get(edge[0]).add(arr);
    }
    
    public int shortestPath(int node1, int node2) {
        return djikstra(node1, node2);
    }

    // uses djikstra algorithm to prompt for min length
    public int djikstra(int node1, int node2) {
        int n = g.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[node1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[0]));

        pq.add(new int[]{0, node1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[1];
            int curCost = cur[0];

            if (curCost > distances[curNode]) {
                continue;
            }

            if (curNode == node2) {
                return curCost;
            }

            for (int[] edge: g.get(curNode)) {
                int neighbor = edge[0];
                int edgeLength = edge[1];
                int cost = edgeLength + distances[curNode];

                if (distances[neighbor] > cost) {
                    distances[neighbor] = cost;
                    pq.add(new int[]{cost, neighbor});
                }
            }

        }

        if (distances[node2] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return distances[node2];
        }

    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */