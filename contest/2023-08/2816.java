// https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode doubleIt(ListNode head) {
        if (head != null ) {
            if (head.val >= 5) {
                head = new ListNode(0 , head);   
            }
            ListNode cur = head;
                while (cur != null) {
                    cur.val = (cur.val * 2) % 10;
                    if (cur.next != null && cur.next.val >= 5) {
                        cur.val++;
                    }
                    cur = cur.next;
                }
        }
        return head;
    }
    
}