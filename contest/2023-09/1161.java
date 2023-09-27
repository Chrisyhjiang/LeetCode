/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int ans = 0;
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            level++;
            int curSum = 0;
            for (int size = q.size(); size > 0; size--) {
                TreeNode curNode = q.poll();
                curSum += curNode.val;
                
                if (curNode.left != null) {
                    q.offer(curNode.left);
                }
                if (curNode.right != null) {
                    q.offer(curNode.right);
                }
                
            }
            if (maxSum < curSum) {
                maxSum = curSum;
                ans = level;
            }
        }
        
        return ans;
    }
}
