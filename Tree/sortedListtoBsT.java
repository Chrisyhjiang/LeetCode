// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
import java.util.*;
public class sortedListtoBsT {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
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
	public static TreeNode sortedListToBST(ListNode head) {
        // find mid use it as the root of the binary tree 
		// write a recursive function that populates everything below run it on two different ends.
		// it is possible to do it without coverting it into a list / array. 
		ArrayList<ListNode> ls = new ArrayList<ListNode>();
		while(head != null) {
			ls.add(head);
			head = head.next;
		}
		if(ls.isEmpty()) {
			return null;
		}else {
			int mid = ls.size() / 2;
			TreeNode root = new TreeNode(ls.get(mid).val);
			root.left = getBranch(0, mid - 1, ls);
			root.right = getBranch(mid + 1, ls.size() - 1, ls);
			return root;
		}
    }
	
	public static TreeNode getBranch(int start, int end, ArrayList<ListNode> ls) {
		TreeNode res = null;
		if(start <= end) {
			int m = (start + end + 1) / 2;
			TreeNode root =  new TreeNode(ls.get(m).val);
			root.left = getBranch(start, m - 1, ls);
			root.right = getBranch(m + 1, end, ls);
			res = root;
		}
        return res;
	}
}
