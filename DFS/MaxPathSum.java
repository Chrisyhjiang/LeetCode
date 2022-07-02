// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class MaxPathSum {
	static int max = Integer.MIN_VALUE;
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
	
	public static void main(String[] args) {
		
	}
	public int maxPathSum(TreeNode root) {
		maxPathSum2(root);
		return max;
	}
	public int maxPathSum2(TreeNode root) {
        if(root == null) {
        	return 0;
        }else {
        	// include the left subtree, the largest value compared to 0. 
        	int leftMax = Math.max(0, maxPathSum2(root.left));
        	// include the right subtree, the largest value compared to 0. 
        	int rightMax = Math.max(0, maxPathSum2(root.right));
        	// the return value always includes the root node. The path is available for the previous node. 
        	int branchMax = root.val + Math.max(leftMax, rightMax);
        	// the greatest max throughout all of the tree. 
        	max = Math.max(max, root.val + leftMax + rightMax);
        	return branchMax;
        }
    }
	
}
