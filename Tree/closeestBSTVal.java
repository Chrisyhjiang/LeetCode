// https://leetcode.com/problems/closest-binary-search-tree-value/
import java.util.*;
public class closeestBSTVal {
	
	Integer closest;
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
	
	public int closestValue(TreeNode root, double target) {
		closest = (int) (2e9 + 1);
		closest(root, target);
		return closest;
    }
	
	
	public void closest(TreeNode root, double target) {
		if(root == null) {
			return;
		}
		if(Math.abs(root.val - target) < Math.abs(closest - target)) {
			closest = root.val;
		}
		closest(root.left, target);
		closest(root.right, target);
	}
}
