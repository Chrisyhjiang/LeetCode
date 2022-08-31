// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
import java.util.*;
public class kthSmallestinBST {
	static List<Integer> ls = new ArrayList<Integer>();
	class TreeNode {
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
	
	public static int kthSmallest(TreeNode root, int k) {
		DFSIn(root, k);
		return ls.get(ls.size()-1);
    }
	
	public static void DFSIn(TreeNode root, int k) {
		if(root.left != null) {
			DFSIn(root.left, k);
		}
		ls.add(root.val);
		if(ls.size() == k) {
			return;
		}
		if(root.right != null) {
			DFSIn(root.right, k);
		}
	}
}
