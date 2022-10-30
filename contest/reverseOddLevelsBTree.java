import java.util.*;
public class reverseOddLevelsBTree {
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
		TreeNode head  = new TreeNode(2, new TreeNode(3, new TreeNode(8), new TreeNode(13)), new TreeNode(5, new TreeNode(21), new TreeNode(34)));
		TreeNode res = reverseOddLevels(head);

	}
	
	public static TreeNode reverseOddLevels(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		Queue<Integer> levels = new LinkedList<Integer>();
		q.add(root);
		
		levels.add(0);
		
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			int level = levels.poll();
			if(level % 2 == 0) {
				if(node.left != null) {
					q.add(node.right);
					q.add(node.left);
					levels.add(level + 1);
					levels.add(level + 1);
				}
			}else {
				if(node.left != null) {
					q.add(node.right);
					q.add(node.left);
					levels.add(level + 1);
					levels.add(level + 1);
				}
			}
			q2.add(node.val);
		}
		
		ArrayList<Integer> ls = new ArrayList<Integer>(q2);
		TreeNode res = construct(new TreeNode(q2.poll()), 0, ls);
		return res;
    }
	
	public static TreeNode construct(TreeNode n, int i, ArrayList<Integer> ls) {
		if(i < ls.size()) {
			n = new TreeNode(ls.get(i));
			n.left = construct(n.left, 2 * i + 1, ls);
			n.right = construct(n.right, 2 * i + 2, ls);
		}
		return n;
	}
	
}
