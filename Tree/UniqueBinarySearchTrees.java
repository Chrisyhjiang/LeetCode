// https://leetcode.com/problems/unique-binary-search-trees-ii/
import java.util.*;

public class UniqueBinarySearchTrees {
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
		// TODO Auto-generated method stub

	}
	public static List<TreeNode> generateTrees(int n) {
		if(n == 0) {
			return new ArrayList<TreeNode>();
		}else {
			return generate(1, n);
		}
		
		
    }
	
	public static ArrayList<TreeNode> generate(int start, int end) {
		// generate all the left and right trees using recursion
		// loop through all left and right trees and the root will be the current i. 
		// base case is start > end
		ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
		if(start > end) {
			trees.add(null);
			return trees;
		}
		
		for(int i = start; i <= end; i++) {
			TreeNode root = new TreeNode(i);
			ArrayList<TreeNode> left = generate(start, i - 1);
			ArrayList<TreeNode> right = generate(i + 1, end);
			for(TreeNode l: left) {
				for(TreeNode r: right) {
					root.left = l;
					root.right = r;
					trees.add(root);
				}
			}
			
			
		}
		return trees;
	}

}
