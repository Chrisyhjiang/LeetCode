

public class BSTDeletion {
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
		TreeNode root = new TreeNode(20 , new TreeNode(10, new TreeNode(5, new TreeNode(5), new TreeNode(8)), new TreeNode(15, new TreeNode(12), new TreeNode(18))), new TreeNode(30));
		deleteNode(root, 10);
		

	}
	
	public static TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }
	
	public static TreeNode delete(TreeNode root, int key) {
		if(root != null) {
			if(root.val == key) {
				if(root.left != null && root.right != null) {
					TreeNode replace = root.right;
					TreeNode temp = root.left;
					TreeNode pointer = root.right;
					while(pointer.left != null) {
						pointer = pointer.left;
					}
					pointer.left = temp;
					return replace;
				}else if (root.left == null) {
					return root.right;
				}else if (root.right == null) {
					return root.left;
				}else {
					return null;
				}
			}else if (root.val > key) {
				root.left = delete(root.left, key);
			}else {
				root.right = delete(root.right, key);
			}
		}
		return root;
	}
}
