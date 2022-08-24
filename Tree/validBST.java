import java.util.*;
public class validBST {
	static LinkedList<Integer> ls;
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
		TreeNode t = new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(5, new TreeNode(4), new TreeNode(6)));
		boolean b = isValidBST2(t);
		System.out.println(b);

	}
	
	
	public static boolean isValidBST2(TreeNode root) {
		return validate(root, null, null);
	}
	
	public static boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }
	
	public static void inOrder(TreeNode root) {
		if(root.left != null) {
			inOrder(root.left);
		}
		ls.add(root.val);
		if(root.right != null) {
			inOrder(root.right);
		}
		
	}
	

	public boolean isValidBST(TreeNode root) {
		ls = new LinkedList<Integer>();
		inOrder(root);
		long cur = Long.MIN_VALUE;
		for(int e: ls) {
			if(e <= cur) {
				return false;
			}else {
				cur = e;
			}
		}
		return true;
    }

}
