//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
import java.util.*; 
public class BTreeLOrderTraversalII {
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
		// 

	}
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ls = new LinkedList<List<Integer>>();
        if(root == null){
            return ls;
        }
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> levels = new LinkedList<Integer>();
		q.add(root);
		levels.add(0);
		LinkedList<Integer> l = new LinkedList<Integer>();
		int prevLevel = - 1;
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			int level = levels.poll();
			if(level != prevLevel) {				
				prevLevel = level;
                if(l.size() != 0){
                    ls.add(0, new LinkedList<Integer>(l)); 
                }
                l.clear();
				l.add(node.val);   
			}else {
				l.add(node.val);
			}
			if(node.left != null) {
				q.add(node.left);
				levels.add(level + 1);
			}
			if(node.right != null) {
				q.add(node.right);
				levels.add(level + 1);
			}
		}
		ls.add(0, new LinkedList<Integer>(l));
		return ls;
    }
}
