import java.util.*;

public class LevelOrder {
	static List<List<Integer>> ls = new ArrayList<List<Integer>>();
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
	public static List<List<Integer>> levelOrder2(TreeNode root) {
		if(root != null){
            populateList(root, 0);    
        }
		return ls;
	}
	
	public static void populateList(TreeNode root, int level) {
		if(ls.size() == level) {
			ls.add(new ArrayList<Integer>());
		}
		if(root == null) {
			return;
		}
		List<Integer> nodes = (ArrayList<Integer>) ls.get(level);
		nodes.add(root.val);
		if(root.left != null) {
			populateList(root.left, level + 1);
		}
		if(root.right != null) {
			populateList(root.right, level + 1);
		}
	}
	
}
