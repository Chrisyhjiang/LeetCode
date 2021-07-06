package LeetCode.LinkedLIst;

import java.math.BigInteger;

public class AddTwoNumbers {
	public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        
        public void add(int a) {
        	ListNode p = this;
        	if (val == 0 && next == null) {
        		val = a;
        	}else {
        		while (p.next != null) {
            		p = p.next;
            	}
        		p.next = new ListNode(a);
        	}
        }
        
        public String toString() {
        	String answer = "";
        	ListNode p = this;
        	while (p != null) {
        		answer += p.val + " ";
        		p = p.next;
        	}
        	return answer;
        }
    }
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String result1 = getNumber(l1);
		String result2 = getNumber(l2);
		
		int pad = Math.abs(result1.length() - result2.length());
		
		if (result1.length() > result2.length()) {
			for (int i = 0; i < pad; i++) {
				result2 = "0" + result2;
			}
		}else if (result1.length() < result2.length()) {
			for (int i = 0; i < pad; i++) {
				result1 = "0" + result1;
			}
		}
		
		int carry = 0;
		int digit = 0;
		ListNode head = null;
		ListNode tail = null;
		
		for (int i = result1.length() - 1; i >= 0; i--) {
			int num1 = Integer.parseInt(Character.toString(result1.charAt(i)));
			int num2 = Integer.parseInt(Character.toString(result2.charAt(i)));
			int sum = num1 + num2 + carry;
			digit = sum % 10;
			carry = sum / 10;
			if (head == null) {
				head = new ListNode(digit);
				tail = head;
			}else {
				tail.next = new ListNode(digit);
				tail = tail.next;
			}
			
		}
		if (carry != 0) {
			tail.next = new ListNode(carry);
		}
		return head;
		
	}
	
	public static String getNumber(ListNode l) {
		ListNode t1 = l;
		String result = "";
		while (t1 != null) {
			result = String.valueOf(t1.val) + result; 
			t1 = t1.next;
		}
		return result;
	}
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		BigInteger result1 = new BigInteger(getNumber(l1));
		BigInteger result2 = new BigInteger(getNumber(l2));
		
		BigInteger finalResult = result1.add(result2);

		
		String ans = finalResult.toString();
		ListNode head = null;
		ListNode tail = null;
		for (int i = ans.length() - 1; i >= 0; i--) {
			String k = Character.toString(ans.charAt(i));
			int p = Integer.parseInt(k);
			if (head == null) {
				head = new ListNode(p);
				tail = head;
			}else {
				tail.next = new ListNode(p);
				tail = tail.next;
			}
		}
		return head;
	}
	
	
	public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
		ListNode first = l1;
		ListNode second = l2;
		int carry = 0;
		ListNode list = new ListNode(0);
		ListNode tail = list;
		
		while (first != null || second != null) {
			
			int a = (first == null) ? 0 : first.val;
			if (first != null) {
				first = first.next;	
			}
			int b = (second == null) ? 0 : second.val;
			if (second != null) {
				second = second.next;
			}
			
			int sum = a + b + carry;
			
			int digit = sum % 10;
			carry = sum / 10;
			
			tail.next = new ListNode(digit);
			tail = tail.next;
			
			
		}
		if (carry != 0) {
			tail.next = new ListNode(carry);
		}
		return list.next;
	}
	
	
	
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode();
		
		l1.add(4);
		l1.add(3);
		l1.add(2);
		System.out.println(l1.toString());
		
		ListNode l2 = new ListNode();
		
		l2.add(5);
		l2.add(7);

		
		System.out.println(l2.toString());
		ListNode list = addTwoNumbers3(l1,l2);
		System.out.println(list);
		
	}
	
	
}
