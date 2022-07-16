// https://leetcode.com/problems/reverse-linked-list/
import java.util.*;
public class reverseLinkedLIst {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode reverseList(ListNode head) {
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
