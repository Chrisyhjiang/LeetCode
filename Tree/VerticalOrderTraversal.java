// https://leetcode.com/problems/binary-tree-vertical-order-traversal/
import java.util.*;
public class VerticalOrderTraversal {
	
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
		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(8, new TreeNode(15), new TreeNode(7)));
		List<List<Integer>> ans = verticalOrder(root);
		for(List<Integer> ls: ans) {
			for(int e: ls) {
				System.out.print(e + " ");
			}
			System.out.println();
		}

	}
	public static List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) {
			return res;
		}
		TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<Integer, ArrayList<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> o = new LinkedList<Integer>();
		q.add(root);
		o.add(0);
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			int order = o.poll();
			ArrayList<Integer> ls;
			if(tm.containsKey(order)) {
				ls = tm.get(order);
			}else {
				ls = new ArrayList<Integer>();
			}
			ls.add(node.val);
			tm.put(order, ls);
			if(node.left != null) {
				q.add(node.left);
				o.add(order - 1);
			}
			if(node.right != null) {
				q.add(node.right);
				o.add(order + 1);
			}
		}
				
		for(ArrayList<Integer> ls : tm.values()) {
			res.add(ls);
		}
		return res;
    }
}
