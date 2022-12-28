import reverseLinkedLIst.ListNode;

// https://leetcode.com/problems/add-two-numbers-ii/
public class addNums {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public static void main(String[] args) {
		

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
	
	public int len(ListNode root) {
		int res = 0;
		while(root != null) {
			res++;
		}
		return res;
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode firstNum = l1;
		ListNode secondNum = l2;
		int lendiff = len()
		if(len(l1) > len(l2)) {
			pad(l2, )
		}else {
			
		}
    }
	
	

}
