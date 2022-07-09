

public class sortList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}else {
			ListNode temp = head;
			ListNode fast = head;
			ListNode slow = head;
			
			while(fast != null && fast.next != null){
				temp = slow;
				slow = slow.next;
				fast = fast.next.next;
			}
			temp.next = null;
			ListNode left = sortList(head);
			ListNode right = sortList(slow);
			return merge(left, right);
		}
		
    }
	
	public ListNode sortList2(ListNode head, int length) {
		if(length == 1) {
			return head;
        }else {
			ListNode leftTail = head;
			for(int i = 0; i < length / 2 - 1; i++) {
				leftTail =  leftTail.next;
			}
			
			int rightLength = length / 2;
			if(length % 2 == 1) {
				rightLength++;
			}
			ListNode right = sortList2(leftTail.next, rightLength);
			leftTail.next = null;
			ListNode left = sortList2(head, length / 2);
			ListNode res = merge(left, right);
			return res;
		}
		
    }
	
	public ListNode merge(ListNode left, ListNode right) {
		ListNode res = new ListNode(0);
		if(left.val <= right.val) {
			res = new ListNode(left.val);
			left = left.next;
		}else {
			res = new ListNode(right.val);
			right = right.next;
		}
		ListNode pointer = res;
		
		while(left != null && right != null) {
			if(left.val <= right.val) {
				pointer.next = new ListNode(left.val); 
				pointer = pointer.next;
				left= left.next;
			}else {
				pointer.next = new ListNode(right.val); 
				pointer = pointer.next;
				right = right.next;
			}
		}
		
		if(left!= null) {
			pointer.next = left;
		}else {
			pointer.next = right;
		}
		return res;
	}
	
	public int findLength(ListNode head) {
		int res = 0;
		while(head != null) {
			res++;
			head = head.next;
		}
		return res;
	}
	
}
