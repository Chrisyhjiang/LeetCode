import java.util.*;
public class InOrder {
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
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        DFSIn(root, ls);
        return ls;
    }
	public static void DFSIn(TreeNode root, List<Integer> ls) {
		if(root.left != null) {
			DFSIn(root.left, ls);
		}
		ls.add(root.val);
		if(root.right != null) {
			DFSIn(root.right, ls);
		}
	}
}
