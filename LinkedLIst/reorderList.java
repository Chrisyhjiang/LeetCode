import reverseLinkedLIst.ListNode;

public class reorderList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void reorderList(ListNode head) {
		if (head != null) {
			ListNode slow = head;
			ListNode fast = head;
			
			while(fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			
			ListNode prev = null;
			ListNode curr = slow;
			ListNode temp;
			while(curr != null) {
				temp = curr.next;
				curr.next = prev;
				prev = curr;
				curr = temp;
			}
			
			ListNode first = head, second = prev;
		    while (second.next != null) {
		      temp = first.next;
		      first.next = second;
		      first = temp;

		      temp = second.next;
		      second.next = first;
		      second = temp;
		    }
			
		}		
		
		
    }
	public static ListNode reverseList(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode tail = null;
        while(head != null) {
        	ListNode temp = new ListNode(head.val);
        	temp.next = tail;
        	tail = temp;
        	head = head.next;
        }
        return tail;
    }

}
