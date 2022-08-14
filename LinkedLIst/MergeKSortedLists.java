import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public static void main(String[] args) {
		ListNode a = new ListNode(1, new ListNode(4, new ListNode(5)));
		ListNode b = new ListNode(1, new ListNode(3, new ListNode(4)));
		ListNode c = new ListNode(2, new ListNode(6));
		ListNode[] arr = new ListNode[3];
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		ListNode res = mergeKLists(arr);
		
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		}
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new cmpfunc());
		for(ListNode p: lists) {
			if(p != null) {
				pq.add(p);
			}
		}
		if(pq.isEmpty()) {
			return null;
		}
		
		ListNode res = pq.poll();
		if(res.next != null) {
			pq.add(res.next);
		}
		ListNode pointer = res;
		while(!pq.isEmpty()) {
			ListNode cur = pq.poll();
			pointer.next = new ListNode(cur.val);
			if(cur.next != null) {
				pq.add(cur.next);
			}
			pointer = pointer.next;
		}
		return res;
		
    }
	static class cmpfunc implements Comparator{
		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			ListNode a = (ListNode) o1;
			ListNode b = (ListNode) o2;
			return a.val - b.val;
		}
	}

}
