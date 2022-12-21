public class robTree {
	
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
	
	public static class pair{
		// wr stands for max value rob with root
		int wr;
		// wor stands for max value rob without root
		int wor;
		pair(int a, int b){
			wr = a;
			wor = b;
		}
		
	}
	
	public static void main(String[] args) {
		TreeNode r = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));
		int res = rob(r);
		System.out.println(res);
	}
	
	public static int rob(TreeNode root) {
		int[] p = getMax(root);
		return Math.max(p[0], p[1]);
    }
	public static int[] getMax(TreeNode root) {
		if(root == null) {
			return new int[]{0,0};
		}else {
			int[] l = getMax(root.left);
			int[] r = getMax(root.right);
			int maxWR = root.val + l[1] + r[1];
			int maxWOR = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
			return new int[] {maxWR, maxWOR};
		}
	}
}
