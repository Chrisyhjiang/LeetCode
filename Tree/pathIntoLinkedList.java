
public class pathIntoLinkedList {
	
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
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static ListNode calculate(TreeNode a, TreeNode b, TreeNode root) {
		String pathToA = getPath(root, "", a.val);
		String pathToB = getPath(root, "", b.val);
		TreeNode temp  = root;
		int i = 0;
		for (i = 0 ; i < Math.min(pathToA.length(), pathToB.length()); i++) {
			char m = pathToA.charAt(i);
			char n = pathToB.charAt(i);
			if (m == n) {
				if (m == 'l') {
					temp = temp.left;
				} else {
					temp = temp.right;
				}
			} else {
				break;
			}
		}
		ListNode lefttoLCA = pathToLinkedList(temp, pathToA, i);
		lefttoLCA = revTrunc(lefttoLCA);
		ListNode LCAtoRight = pathToLinkedList(temp, pathToB, i);
		
		if (lefttoLCA != null) {
			lefttoLCA.next = LCAtoRight;
		} else {
			lefttoLCA = LCAtoRight;
		}
		
		return lefttoLCA;
		
	}
	
	public static ListNode pathToLinkedList(TreeNode root, String path, int idx) {
		ListNode res = new ListNode();
		ListNode temp = res;
		
		for (int i = idx; i < path.length(); i++) {
			temp.val = root.val;
			temp.next = new ListNode();
			if (path.charAt(i) == 'l') {
				root = root.left;
			} else {
				root = root.right;
			}
			temp = temp.next;
		}
		temp.val = root.val;
		return res;
	}
	
	public static ListNode revTrunc(ListNode head) {
		if(head == null) {
			return null;
		}
		head = head.next;
		ListNode tail = null;
        while(head != null) {
        	ListNode temp = new ListNode(head.val);
        	temp.next = tail;
        	tail = temp;
        	head = head.next;
        }
        return tail;
	}
	
	
	public static String getPath(TreeNode root, String path, int dest) {
		if(root.val == dest) {
			return path;
		}else {
			if(root.left == null && root.right == null) {
				return null;
			}else if(root.left == null) {
				return getPath(root.right, path + "r", dest);
			}else if(root.right == null){
				return getPath(root.left, path + "l", dest);
			}else {
				String s = getPath(root.left, path + "l", dest);
				if(s!=null) {
					return s;
				}else {
					return getPath(root.right, path + "r", dest);
				}
			}
		}
	}
	
	
	public static void main (String[] args) {
		TreeNode root = new TreeNode(1, 
				new TreeNode(2, new TreeNode(4, new TreeNode(5), null), null), 
				new TreeNode(3, new TreeNode(6), new TreeNode(7)));
		
		ListNode res = calculate(new TreeNode(2), new TreeNode(7), root);
		/*							1
		 * 						2		3
		 *					4		6		7
		 *				5 
		
		 */
	}

}
