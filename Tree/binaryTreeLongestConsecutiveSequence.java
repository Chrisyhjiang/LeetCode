// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
public class binaryTreeLongestConsecutiveSequence {
	static int maxLength;
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
		TreeNode root = new TreeNode(2, null, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null));
		int ans = longestConsecutive(root);
		System.out.println(ans);
	}

	public static int longestConsecutive(TreeNode root) {
		if(root == null) {
			return 0;
		}else {
			traverse(root, null, 0);
			return maxLength;
		}
    }
	
	public static void traverse(TreeNode root, TreeNode parent, int length) {
		if(root == null) {
			return;
		}else {
			if(parent != null && root.val == parent.val + 1) {
				length+=1;
			}else {
				length = 1;
			}
			maxLength = Math.max(length, maxLength);
			traverse(root.left, root, length);
			traverse(root.right, root, length);
		}
		
	}
	
}
