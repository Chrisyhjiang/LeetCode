
import java.util.*;

public class PseudoPalindrome {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int v, TreeNode l, TreeNode r){
			val = v;
			l = left;
			r = right;
		}
		
		TreeNode(){
			val = 0;
			left = null;
			right = null;
		}
		
		
	}
	
	public int pseudoPalindromicPaths(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<int[]> path = new Stack<int[]>();
		int result = 0;
		s.add(root);
		int[] rootPath = new int[10];
		
		path.push(rootPath);
		
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			int[] p = path.pop();
			p[node.val] += 1;
			
			if (node.left != null) {
				s.push(node.left);
				path.push(p);
			}
			
			if (node.right != null) {
				s.push(node.right);
				path.push(p);
			}
			
			if (node.right == null && node.left == null) {
				// leaf node here
				if (isPseudoPalindrome(p)) {
					result++;
				}
				
			}
			
			
		}
		
		return result;
		
	}
	
	public boolean isPseudoPalindrome(int[] arr) {
		int count = 0;
		
		for (int e: arr) {
			if (e % 2 == 1) {
				count++;
			}
		}
		
		return count <= 1;
	}
	
	
}
