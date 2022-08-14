import java.util.PriorityQueue;

public class MergeKSortedLists {
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
	
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		}
		ListNode res = new ListNode();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
		for(ListNode node: lists) {
			while(node != null) {
				pq.add(node.val);
				node = node.next;
			}
		}
        if(pq.isEmpty()) {
        	return null;
        }
		res = new ListNode(pq.poll());
		ListNode pointer = res;
		while(!pq.isEmpty()) {
			pointer.next = new ListNode(pq.poll());
			pointer = pointer.next;
		}
		return res;
    }
	

}
