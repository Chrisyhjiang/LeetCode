import java.util.*;
public class InfectTime {
	static HashMap<Integer, ArrayList<Integer>> neighbors;
	static boolean[] visited;
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		 }
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(5, null, new TreeNode(4, new TreeNode(9), new TreeNode(2)) ), new TreeNode(3, new TreeNode(10), new TreeNode(6)));
		int ans = amountOfTime(root, 3);
		System.out.println(ans);
	}
	
	public static int amountOfTime(TreeNode root, int start) {
        neighbors = new HashMap<Integer, ArrayList<Integer>>();
        populateNeighbors(root);
        visited = new boolean[100001];
        
        int res = height(start);
        return res;
	}
	
	public static void populateNeighbors(TreeNode root) {
		if(root == null) {
			return;
		}
		ArrayList<Integer> ls = new ArrayList<Integer>();
		if(neighbors.containsKey(root.val)) {
			ls = neighbors.get(root.val);
		}
		if(root.right != null) {
			int key = root.right.val;
			ls.add(key);
			ArrayList<Integer> edge = new ArrayList<Integer>();
			if(neighbors.containsKey(key)) {
				edge = neighbors.get(key);
			}
			edge.add(root.val);
			neighbors.put(key, edge);
		}
		if(root.left != null) {
			int key = root.left.val;
			ls.add(key);
			ArrayList<Integer> edge = new ArrayList<Integer>();
			if(neighbors.containsKey(key)) {
				edge = neighbors.get(key);
			}
			edge.add(root.val);
			neighbors.put(key, edge);
		}
		
		neighbors.put(root.val, ls);
		populateNeighbors(root.right);
		populateNeighbors(root.left);
	}

	
	public static int height(int cur) {
		visited[cur] = true;
		ArrayList<Integer> neighbor = neighbors.get(cur);
		int max = 0;
		for(int e: neighbor) {
			if(!visited[e]) {
				max = Math.max(max, height(e)+1);
			}	
		}
		return max;
	}
}
