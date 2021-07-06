package LeetCode.Tree;

public class UniversalPath {
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
	int ans;
	public int LongestUniversalPath(TreeNode root) {
		ans = 0;
		return ans;
	}
	public int findLength(TreeNode root) {
		if(root == null) {
			return 0;		
		}else {
			int left = findLength(root.left); // recursive call, finds length of left
			int right = findLength(root.right); // recursive call, finds length of left
			
			int leftLength = 0, rightLength = 0; // instantiated as zero because this will allow us to find the ans value through using maximum. 
			// if either one is zero, ans will always be the greatest since it is always updated. 
				
			if (root.left!= null && root.left.val == root.val) {// catches all four cases
				leftLength = left + 1;
			}
			if (root.right!= null && root.right.val == root.val) {
				rightLength = right + 1;
			}
			
			ans = Math.max(ans, leftLength + rightLength); // if even one of them is not equal, ans must be >= than the other path
			return Math.max(leftLength, rightLength);
			
		}
	}
}
