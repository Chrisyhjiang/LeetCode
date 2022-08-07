import java.util.*;
public class reachableNode {
	static HashMap<Integer, ArrayList<Integer>> children;
	static boolean[] visited;
	public static void main(String[] args) {
		int n = 7;
		int[] restricted = {4,2,1};
		int[][] edges = {{0,1},{0,2},{0,5},{4,0},{3,2},{5,6}};
		int ans = reachableNodes(n, edges, restricted);
		System.out.println(ans);
	}
	public static int reachableNodes(int n, int[][] edges, int[] restricted) {
		HashSet<Integer> hs = new HashSet<Integer>();
		children = new HashMap<Integer, ArrayList<Integer>>();
		for(int e: restricted) {
			hs.add(e);
		}
		for(int i = 0; i < edges.length; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			if(children.containsKey(a)) {
				children.get(a).add(b);
			}else {
				ArrayList<Integer> ls = new ArrayList<Integer>();
				ls.add(b);
				children.put(a, ls);
			}
			if(children.containsKey(b)) {
				children.get(b).add(a);
			}else{
				ArrayList<Integer> ls = new ArrayList<Integer>();
				ls.add(a);
				children.put(b, ls);
			}
		}
		visited = new boolean[n];
		int count = traverse(0, hs);
		return count;
    }
	
	public static int traverse(int node, HashSet<Integer> restricted) {
		if(restricted.contains(node)) {
			return 0;
		}
		if(visited[node]) {
			return 0;
		}else {
			visited[node] = true;
			int res = 1;
			ArrayList<Integer> ls = children.get(node);
			for(int n: ls) {
				res += traverse(n, restricted);
			}
			return res;
		}
	}
}
