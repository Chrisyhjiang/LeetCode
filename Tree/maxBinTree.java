// https://leetcode.com/problems/maximum-binary-tree/submissions/865828610/
public class maxBinTree {
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
	
	int[] arr;
	int n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		arr = nums;
		n = nums.length;
		if(nums.length == 0) {
			return null;
		}
		TreeNode res = buildTree(0, n - 1);
		return res;
    }
	
	public int findMaxIndex(int start, int end) {
		// kind of like binary search
		int res = -1;
		int max = -1;
		for(int i = start; i <= end; i++) {
			if(arr[i] > max) {
				res = i;
				max = arr[i];
			}
		}
		
		return res;
	}
	public TreeNode buildTree(int l, int r) {
		if(l == -1) {
			return null;
		}
		if(r == n) {
			return null;
		}
		if(l > r) {
			return null;
		}
		int maxIdx = findMaxIndex(l, r);
		TreeNode ans = new TreeNode(arr[maxIdx]);
		ans.left = buildTree(l, maxIdx - 1);
		ans.right = buildTree(maxIdx + 1, r);
		return ans;
	}
	

}
