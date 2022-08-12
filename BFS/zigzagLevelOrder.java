// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/
import java.util.*;
public class zigzagLevelOrder {
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
		
	}
	
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		LinkedList<Integer> level = new LinkedList<Integer>();
		int curLevel = 1;
	    int nextLevel = 0;
		boolean leftOrder = true;
		while(!q.isEmpty()) {
			TreeNode n = q.poll();
			if(level.size() < curLevel && leftOrder) {
				level.add(n.val);
			}else if (level.size() < curLevel && !leftOrder) {
				level.add(0, n.val);
			}else if(level.size() == curLevel) {
				leftOrder = !leftOrder;
				res.add(level);
				level = new LinkedList<Integer>();
				level.add(n.val);
				curLevel = nextLevel;
				nextLevel = 0;
			}
			if(n.left!= null) {
				q.add(n.left);
				nextLevel++;
			}
			if(n.right!= null) {
				q.add(n.right);
				nextLevel++;
			}
		}
		res.add(level);
		return res;
	}
}
