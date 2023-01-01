// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class goodNodes {
	static int res = 0;
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
	
	public int goodNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		traverse(root.left, root.val);
		traverse(root.right, root.val); 
		return 1 + res;
		
    }
	
	public void traverse(TreeNode root, int max) {
		if(root == null) {
			return;
		}
		if(root.val >= max) {
			res++;
		}
		traverse(root.left, Math.max(root.val, max));
		traverse(root.right, Math.max(root.val, max));
	}

}
