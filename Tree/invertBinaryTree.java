// https://leetcode.com/problems/invert-binary-tree/submissions/
import java.util.*;

public class invertBinaryTree {
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
		// TODO Auto-generated method stub

	}
	public TreeNode invertTree(TreeNode root) {
		if(root != null) {
			TreeNode temp = root.left;
	    	root.left = root.right;
	    	root.right = temp;
	    	invertTree(root.left);
	    	invertTree(root.right);
		}
        return root;
    }
}
