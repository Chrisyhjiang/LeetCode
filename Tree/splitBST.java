// https://leetcode.com/problems/split-bst/
public class splitBST {
	static Integer sClose = -1001;
	static Integer lClose = 3000;
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
		TreeNode n = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode (3)), new TreeNode(6, new TreeNode(5) ,new TreeNode(8)));
		TreeNode[] arr = splitBST(n, 2);
	}
	
	public static TreeNode[] splitBST(TreeNode root, int target) {
        if(root == null) {
        	return new TreeNode[] {null, null};
        }else if (root.val <= target) {
        	TreeNode[] arr = splitBST(root.right, target);
        	root.right = arr[0];
        	arr[0] = root;
        	return arr;
        }else {
        	TreeNode[] arr = splitBST(root.left, target);
        	root.left = arr[1];
        	arr[1] = root;
        	return arr;
        }
    }
	
	

}
