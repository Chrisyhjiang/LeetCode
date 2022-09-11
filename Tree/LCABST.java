// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LCABST {
	
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
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while(root != null) {
			if(root.val == q.val) {
				return q;
			}else if (root.val == p.val) {
				return p;
			}else {
				if(p.val < root.val && q.val < root.val) {
					root = root.left;
				}else if(p.val > root.val && q.val > root.val) {
					root = root.right;
				}else {
					return root;
				}
			}
		}
		return null;
	}
	
}
