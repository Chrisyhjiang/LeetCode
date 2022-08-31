// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
import java.util.*;
public class kthSmallestinBST {
	static int ans;
    static int m;
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
        m = k;
		DFSIn(root);
		return ans;
    }
	
	public static void DFSIn(TreeNode root) {
		if(root != null) {
			if(m > 0) {
				DFSIn(root.left);
                if(m > 0){
                    ans = root.val;
                    m--;
                }
				DFSIn(root.right);
			}
		}
	}
}
