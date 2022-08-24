// https://leetcode.com/problems/path-sum-ii/
import java.util.*;
public class targetSumII {
static List<List<Integer>> res;	
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
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
	
	public static void backtrack(TreeNode node, int remain, List<Integer> ls, List<List<Integer>> res) {
        if (node == null) {
            return;
        }else {
        	ls.add(node.val);
            
            if (remain == node.val && node.left == null && node.right == null) {
                res.add(new ArrayList<Integer>(ls));
            }else {
                backtrack(node.left, remain - node.val, ls, res);
                backtrack(node.left, remain - node.val, ls, res);
            }
            ls.remove(ls.size() - 1);
        }
        
    }
}
