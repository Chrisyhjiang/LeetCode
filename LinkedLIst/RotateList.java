// https://leetcode.com/problems/rotate-list/
public class RotateList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
        	return head;
        }
		int length = findLength(head);
        ListNode fast = head;
        ListNode slow = head;
        
        int rotate = k % length;
        if(rotate == 0){
            return head;
        }
        for(int i = 0; i < rotate; i++) {
        	fast = fast.next;
        }
        
        while(fast.next != null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode pointer = temp;
        while(pointer.next != null) {
        	pointer = pointer.next;
        }
        pointer.next = head;
        return temp;
    }
	
	public int findLength(ListNode head) {
		int length = 0;
		while(head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
}
