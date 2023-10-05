class Solution {
    Stack<Integer> st;
	List<Integer> graph;
	List<List<Integer>> reverse;
	Integer n;
	List<List<Integer>> scc;
    // find strongly connected components using kosaraju algorithm
    // two dfs one on graph one with a reverse graph based on time of solve. 
    // things that are in the connected component is the size of the component 
    // things that are not in the component is 1 + the number the nieghbor count is (solve using recursion)
    public int[] countVisitedNodes(List<Integer> edges) {
        st = new Stack<Integer>();
        graph = edges;
        n = edges.size();
        
        reverse = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            reverse.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < n; i++) {
        	reverse.get(graph.get(i)).add(i);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited);
            }
        }
        Arrays.fill(visited, false);
        scc = new ArrayList<List<Integer>>();
        while (!st.isEmpty()) {
            int head = st.pop();
            if (!visited[head]) {
            	List<Integer> comp = new ArrayList<Integer>();
                dfs2(head, visited, comp);
                scc.add(comp);
            }
        }
        int[] res = new int[n];

        for (List<Integer> ls: scc) {
            if (ls.size() > 1) {
                for (int i: ls) {
                    res[i] = ls.size();
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) {
                nonCycle(i, res);
            }
        }
        return res;
    }


    public void dfs(int head, boolean[] visited) {
        visited[head] = true;
        if (!visited[graph.get(head)]) {
        	dfs(graph.get(head), visited);
        }
        st.push(head);
    }

    public void dfs2(int head, boolean[] visited, List<Integer> comp) {
        visited[head] = true;
    	comp.add(head);
        for (int h: reverse.get(head)) {
        	if (!visited[h]) {
        		dfs2(h, visited, comp);
        	}
        }
    }
    // calculates the results of the elements that are not in a cycle. 
    public int nonCycle(int head, int[] res) {
        if (res[head] == 0) {
            res[head] = 1 + nonCycle(graph.get(head), res);   
        }
        return res[head];
    }

}