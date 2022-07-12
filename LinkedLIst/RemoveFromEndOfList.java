// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveFromEndOfList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// uses three pointers left and right has a fixed distance of n. 
		// prev is a pointer that is used for removal. 
        ListNode right = head;
        ListNode left = null;
        
        for(int i = 0; i < n; i++){
            right = right.next;
        }
        
        while(right != null){
        	if(left == null) {
        		left = head;
        	}else {
                left = left.next;
        	}
        	right = right.next;
        }
        // if we need to remove the first node. i.e left did not move. 
        if(left == null){
           return head.next;
        }else{
        	// cleans up the nodes for removal. 
        	ListNode temp = left.next;
            left.next = left.next.next;
            temp.next = null;
        }
        return head;
    }
	public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode right = head;
		ListNode left = head;
        ListNode prev = null;
        // left is the node that needs to be removed prev is the node infront of it. 
        for(int i = 0; i < n; i++){
            right = right.next;
        }
        
        while(right != null){
            prev = left;
            left = left.next;
            right = right.next;
        }
        
        if(prev == null){
           return head.next;
        }else{
            prev.next = left.next;
        }
        return head;
    }
	
	public static void main(String[] args) {
		

	}

}
