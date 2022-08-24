// https://leetcode.com/problems/reverse-linked-list-ii/

public class reverseLinkedListII {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public static void main(String[] args) {
		ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ListNode res = reverseBetween(l, 2, 4);
	}

	public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode cur = head, prev = null;
        while (left > 1) {
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }
        ListNode mid = prev;
        ListNode tail = cur;

        ListNode temp = null;
        while (right > 0) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            right--;
        }

        if (mid != null) {
            mid.next = prev;
        }else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
