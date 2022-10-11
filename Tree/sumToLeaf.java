public class sumToLeaf {
	static int res;
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
		TreeNode r = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
		int res = sumNumbers(r);
		System.out.println(res);
	}
	
	public static int sumNumbers(TreeNode root) {
		if(root == null) {
			return 0;
		}
		getSum(root, 0);
        return res;
    }
	
	public static void getSum(TreeNode root, int curNum) {
		curNum = curNum * 10 + root.val;
		if(root.left == null && root.right == null) {// leaf node
			res += curNum;
		}else if(root.left == null) {
			res += curNum;
			getSum(root.right, curNum);
		}else if (root.right == null) {
			res += curNum;
			getSum(root.right, curNum);
		}else {
			getSum(root.left, curNum);
			getSum(root.right, curNum);
		}
		
	}
}
