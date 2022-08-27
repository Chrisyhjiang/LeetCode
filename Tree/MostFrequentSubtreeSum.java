// https://leetcode.com/problems/most-frequent-subtree-sum/
import java.util.*;

public class MostFrequentSubtreeSum {
	static HashMap<Integer, Integer> hm; 
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
	public static int[] findFrequentTreeSum(TreeNode root) {
		// sum is the key, occurence of sum is the value;
        hm = new HashMap<Integer, Integer>();
        traverse(root);
        ArrayList<Integer> ls = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        
        for(int key: hm.keySet()) {
        	int times = hm.get(key);
        	if(times > max) {
        		ls.clear();
        		max = hm.get(key);
        		ls.add(key);
        	}else if(hm.get(key) == max) {
        		ls.add(key);
        	}
        }
        int[] res = new int[ls.size()];
        for(int i = 0; i < res.length; i++) {
        	res[i] = ls.get(i);
        }
        return res;
    }
	
	public static int traverse(TreeNode root) {
		if(root == null) {
			return 0;
		}else {
			int leftSum = traverse(root.left);
			int rightSum = traverse(root.right);
			int totalSum = root.val + leftSum + rightSum;
			if(hm.containsKey(totalSum)) {
				hm.put(totalSum, hm.get(totalSum) + 1);
			}else {
				hm.put(totalSum, 1);
			}
			return totalSum;
		}
	}
	
}
