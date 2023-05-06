import java.util.*;

public class graphIsTree {
	static boolean[] visited;
	static HashSet<Integer> checked;
	public static void main(String[] args) {
		int[][] edges = {{0,1}};
		int n = 2;
		boolean b = validTree(n, edges);
		System.out.println(b);
	}
	
	public static boolean validTree(int n, int[][] edges) {
//		For the graph to be a valid tree, it must have exactly n - 1 edges. 
//		Any less, and it can't possibly be fully connected. Any more, and it has to contain cycles. 
//		Additionally, if the graph is fully connected and contains exactly n - 1 edges, 
//		it can't possibly contain a cycle, and therefore must be a tree!
		
		if (edges.length != n - 1) {
			return false;
		}
		
		ArrayList<Integer>[] graph = new ArrayList[n];
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < edges.length; i++) {
			graph[edges[i][0]].add(edges[i][1]);
			graph[edges[i][1]].add(edges[i][0]);
		}
		visited = new boolean[n];
		checked = new HashSet<Integer>();
		dfs(0, graph);
		return checked.size() == n;
    }
	
	
	public static void dfs(int node,  ArrayList<Integer>[] graph) {
		if (checked.contains(node)) {
			return;
		}
		checked.add(node);
		
		ArrayList<Integer> neighbors = graph[node];
		for(int e: neighbors) {
			dfs(e, graph);
		}
	}

}
