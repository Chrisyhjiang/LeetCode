// https://leetcode.com/problems/find-leaves-of-binary-tree/
import java.util.*;
public class findLeaves {
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
		TreeNode n  = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
		List<List<Integer>> res = findLeaves(n);
		
	}
	
	public static List<List<Integer>> findLeaves(TreeNode root) {
		TreeNode l = getLevels(root);
		Stack<TreeNode> st = new Stack<TreeNode>();
		Stack<TreeNode> levels = new Stack<TreeNode>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = 0; i <= l.val; i++) {
			res.add(new ArrayList<Integer>());
		}
		st.push(root);
		levels.push(l);
		while(!st.isEmpty()) {
			TreeNode n = st.pop();
			TreeNode level = levels.pop();
			res.get(level.val).add(n.val);
			if(n.left != null) {
				st.push(n.left);
				levels.push(level.left);
			}
			if(n.right != null) {
				st.push(n.right);
				levels.push(level.right);
			}
			
		}
		return res;
    }
	
	public static TreeNode getLevels(TreeNode n) {
		if(n == null) {
			return null;
		}
		TreeNode l = getLevels(n.left);
		TreeNode r = getLevels(n.right);
		TreeNode cur = new TreeNode();
		if(l == null && r == null) {
			cur.val = 0;
		}else if(l == null) {
			cur.val = r.val + 1;
		}else if (r == null) {
			cur.val = l.val + 1;
		}else {
			cur.val = Math.max(l.val, r.val) + 1;
		}
		cur.left = l;
		cur.right = r;
		return cur;
	}

}
