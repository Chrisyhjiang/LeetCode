// https://leetcode.com/problems/minimum-height-trees/description/
import java.util.*;
public class MHTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (n == 1) {
			res.add(0);
			return res;
		}
		
		if (n == 2) {
			res.add(0);
			res.add(1);
			return res;
		}
		// basically the equivalent of finding centroids in a graph. 
		// start at leaf nodes, which obviously cannot be centroids. 
		// remove all leaf nodes and track. 
		// since we are trimming out the leaf nodes layer by layer, a BFS like solution is necessary. 
		// therefore the use of a queue.
		int[] deg = new int[n];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		Queue<Integer> q = new LinkedList<Integer>();
		// build an undirect graph using adjancency list. 
		for (int[] arr: edges) {
			deg[arr[0]]++;
			deg[arr[1]]++;
			graph.get(arr[0]).add(arr[1]);
			graph.get(arr[1]).add(arr[0]);
		}
		// the queue contains only things with deg 1. IN other words, it represents all the current leaf nodes in that iteration. 
		for(int i = 0; i < n; i++) {
			if (deg[i] == 1) {
				q.add(i);
			}
		}
		
		while (n > 2) {
			int sz = q.size();
			n -= sz;
			while (sz > 0 ) {
				int v = q.poll();
				for(int k: graph.get(v)) {
					deg[k]--;
					if(deg[k] == 1) {
						q.add(k);
					}
				}
				sz--;
			}
		}
		res.addAll(q);
		return res;
    }
	

}
