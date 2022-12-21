

public class mergeTwoSortedLinkedlIst {
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
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }
	
	public ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null ) {
			return l2;
		}else if (l2 == null) {
			return l1;
		}else {
			if(l1.val <= l2.val) {
				return new ListNode(l1.val, merge(l1.next, l2));
			}else {
				return new ListNode(l2.val, merge(l1, l2.next));
			}
		}
	}
}
