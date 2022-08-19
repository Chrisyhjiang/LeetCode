// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LCABinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        String first = findPath(root, "", p.val);
        String second = findPath(root, "", q.val);
        for(int i = 0; i < Math.min(first.length(), second.length()); i++) {
        	char c = first.charAt(i);
        	char d = second.charAt(i);
        	if(c == d) {
        		if(c == 'l') {
        			root = root.left;
        		}else {
        			root = root.right;
        		}
        		
        	}else {
        		break;
        	}
        }
        return root;
    }
	public String findPath(TreeNode root, String path, int dest) {
		if(root.val == dest) {
			return path;
		}else {
			if(root.left == null && root.right == null) {
				return null;
			}else if(root.left == null) {
				return findPath(root.right, path + "r", dest);
			}else if(root.right == null){
				return findPath(root.left, path + "l", dest);
			}else {
				String s = findPath(root.left, path + "l", dest);
				if(s!=null) {
					return s;
				}else {
					return findPath(root.right, path + "r", dest);
				}
			}
		}
	}

}
