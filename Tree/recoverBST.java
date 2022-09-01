// https://leetcode.com/problems/recover-binary-search-tree/
import java.util.*;
public class recoverBST {
	static List<Integer> ls;
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
	
	public static void recoverTree(TreeNode root) {
		ls = new ArrayList<Integer>();
		inOrder(root);
		// code to find two swapped elements in an almost sorted list. 
		int x = -1; int y = -1;
		boolean firstSwap = false;
		for(int i = 0; i < ls.size() - 1; i++) {
			if(ls.get(i) > ls.get(i+1)) {
				y = ls.get(i+1);
				if(!firstSwap) {
					x = ls.get(i);
					firstSwap = true;
				}else {
					break;
				}
			}
		}
		int[] swap = new int[] {x, y};
		recover(root, swap, 2);
    }
	
	public static void inOrder(TreeNode root) {
		if(root != null) {
			inOrder(root.left);
			ls.add(root.val);
			inOrder(root.right);
		}
	}
	
	public static void recover(TreeNode root, int[] arr, int count) {
		if(root != null && count > 0) {
			if(root.val == arr[0]) {
				root.val = arr[1];
				count--;
			}else if (root.val == arr[1]) {
				root.val = arr[0];
				count--;
			}
			recover(root.left, arr, count);
			recover(root.right, arr, count);
		}
	}
	// Morris in order traversal O(2n) time complexity, O(1) space
	public void swap(TreeNode a, TreeNode b) {
	    int tmp = a.val;
	    a.val = b.val;
	    b.val = tmp;
	  }

	  public void recoverTree(TreeNode root) {
	    // predecessor is a Morris predecessor. 
	    // In the 'loop' cases it could be equal to the node itself predecessor == root.
	    // pred is a 'true' predecessor, 
	    // the previous node in the inorder traversal.
	    TreeNode x = null, y = null, pred = null, predecessor = null;

	    while (root != null) {
	      // If there is a left child
	      // then compute the predecessor.
	      // If there is no link predecessor.right = root --> set it.
	      // If there is a link predecessor.right = root --> break it.
	      if (root.left != null) {
	        // Predecessor node is one step left 
	        // and then right till you can.
	        predecessor = root.left;
	        while (predecessor.right != null && predecessor.right != root)
	          predecessor = predecessor.right;

	        // set link predecessor.right = root
	        // and go to explore left subtree
	        if (predecessor.right == null) {
	          predecessor.right = root;
	          root = root.left;
	        }
	        // break link predecessor.right = root
	        // link is broken : time to change subtree and go right
	        else {
	          // check for the swapped nodes
	          if (pred != null && root.val < pred.val) {
	            y = root;
	            if (x == null) x = pred;
	          }
	          pred = root;

	          predecessor.right = null;
	          root = root.right;
	        }
	      }
	      // If there is no left child
	      // then just go right.
	      else {
	        // check for the swapped nodes
	        if (pred != null && root.val < pred.val) {
	          y = root;
	          if (x == null) x = pred;
	        }
	        pred = root;

	        root = root.right;
	      }
	    }
	    swap(x, y);
	  }
	
}
