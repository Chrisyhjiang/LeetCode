// https://leetcode.com/problems/count-complete-tree-nodes/ 
import java.util.*;
public class completeTreeNodes {
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
		System.out.println(1<<2-1);

	}
	
	public int computeDepth(TreeNode node) {
	    int d = 0;
	    while (node.left != null) {
	      node = node.left;
	      d++;
	    }
	    return d;
	  }

	  // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
	  // Return True if last level node idx exists. 
	  // Binary search with O(d) complexity.
	  public boolean exists(int idx, int d, TreeNode node) {
	    int left = 0, right = (int)Math.pow(2, d) - 1;
	    for(int i = 0; i < d; ++i) {
	      int pivot = left + (right - left) / 2;
	      if (idx <= pivot) {
	        node = node.left;
	        right = pivot;
	      }
	      else {
	        node = node.right;
	        left = pivot + 1;
	      }
	    }
	    return node != null;
	  }

	  public int countNodes(TreeNode root) {
	    // if the tree is empty
	    if (root == null) { 
	    	return 0;
	    }

	    int level = computeDepth(root);
	    // if the tree contains 1 node
	    if (level == 0) {
	    	return 1;
	    }
	    int count = 1<<level;
	    int left = 1;
	    int right = count - 1;
	    int pivot;
	    while (left <= right) {
	      pivot = left + (right - left) / 2;
	      if (exists(pivot, level, root)) {
	    	  left = pivot + 1;
	      }else { 
	    	  right = pivot - 1;
	      }
	    }

	    return count - 1 + left;
	  }
}
