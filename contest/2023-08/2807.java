// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode();
        ListNode temp = res;

        while (head.next != null) {
            int a = head.val;
            int b = head.next.val;
            temp.val = a;
            temp.next = new ListNode(gcd(Math.max(a, b),Math.min(a,b)), new ListNode());
            temp = temp.next.next;
            head = head.next;
        }
        temp.val = head.val;
        return res;
    }

    public int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
