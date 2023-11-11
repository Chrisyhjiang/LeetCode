/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    static TreeNode res;
    public String serialize(TreeNode root) {
       if (root == null) {
           return "";
       }
       Queue<TreeNode> q = new LinkedList<>();
       StringBuilder res = new StringBuilder();
       q.add(root);
       while(!q.isEmpty()) {
           TreeNode temp = q.poll();
           if (temp == null) {
               res.append("!,");
               continue;
           }
           res.append(temp.val + ",");
           q.add(temp.left);
           q.add(temp.right);
       }
       return res.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] ans = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(ans[0]));
        q.add(root);
        for (int i = 1; i < ans.length; i++) {
            TreeNode tmp = q.poll();
            if (!ans[i].equals("!")) {
                TreeNode l = new TreeNode(Integer.parseInt(ans[i]));
                tmp.left = l;
                q.add(l);
            }
            if (!ans[++i].equals("!")) {
                TreeNode r = new TreeNode(Integer.parseInt(ans[i]));
                tmp.right = r;
                q.add(r);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));