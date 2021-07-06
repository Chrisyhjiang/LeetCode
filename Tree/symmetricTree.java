package LeetCode.Tree;
// https://leetcode.com/problems/symmetric-tree/submissions/
public class symmetricTree {
	public class TreeNode {
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
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			// null checking
			return true;
		}else {
			// run recursive algorithm
			return isMirror(root.left, root.right);
		}
	}
	
	public boolean isMirror(TreeNode l, TreeNode r) {
		if (l == null && r == null) {
			// if both things are null, then return true
			return true;
		}else {
			// since we are using and if one of these conditions fail, it returns false
			// if the left is null and the right isn't null, we return false, vice versa. 
			// then we compare the left value = right value and isMirror for both instances of left and right. 
			return l != null && r != null && l.val == r.val && isMirror(l.left, r.right) && isMirror(r.left, l.right);
			
		}
		
	}
}


