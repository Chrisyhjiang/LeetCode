// https://leetcode.com/problems/closest-binary-search-tree-value-ii/
import java.util.*;
public class closestVal2 {
	
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
		
	}
	
	public static List<Integer> closestKValues(TreeNode root, double target, int k) {
		Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> Math.abs(o1 - target) > Math.abs(o2 - target) ? -1 : 1);
		closest(root, k, pq);
		return new ArrayList<>(pq);
    }
	
	// heap problem
	public static void closest(TreeNode root, int k, Queue<Integer> pq) {	
		if(root == null) {
			return;
		}
		closest(root.left, k, pq);
		pq.add(root.val);
		if(pq.size() > k) {
			pq.remove();
		}
		closest(root.right, k, pq);
	}
}
