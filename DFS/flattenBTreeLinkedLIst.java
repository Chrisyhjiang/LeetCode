

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class flattenBTreeLinkedLIst {
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
		// TODO Auto-generated method stub

	}
	
	
	public void flatten(TreeNode root) {
		if(root != null) {
			flatten(root.left);
			flatten(root.right);
			if(root.left != null && root.right == null) {
				root.right = root.left;
				root.left = null;
			}else if(root.left != null && root.right != null) {
				TreeNode temp = root.right;
				root.right = root.left;
				TreeNode pointer = root.left;
				root.left = null;
				while(pointer.right != null) {
					pointer = pointer.right;
				}
				pointer.right = temp;
			}
			
		}
    }
	
}
