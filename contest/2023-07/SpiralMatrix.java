import java.util.*;


public class SpiralMatrix {
	static int[][] res;
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		int m = 3;
		int n = 5;
		ListNode head = new ListNode(3);
		
		System.out.println(-1);
	}
	
	public static int[][] spiralMatrix(int m, int n, ListNode head) {
		int count = 0;
		res = new int[m][n];
		int k = Math.min(m, n);
		outerLoop:
		for(int level = 0; level < (k + 1) / 2; level++) {
			// level to fill shell; 
			for(int j = level; j < n - level; j++) {
				if(head != null) {
					res[level][j] = head.val;
					head = head.next;
					count++;
				}else {
					res[level][j] = -1;
					count++;
				}
				if(count == m*n) {
					break outerLoop;
				}
			}
			
			for(int i = level + 1; i < m - level - 1; i++) {
				if(head != null) {
					res[i][n - level - 1] = head.val;
					head = head.next;
					count++;
				}else {
					res[i][n - level - 1] = -1;
					count++;
				}
			}
			
			for(int j = n - level - 1; j >= level; j--) {
				if(head != null) {
					res[m - 1- level][j] = head.val;
					head = head.next;
					count++;
				}else {
					res[m - 1 - level][j] = -1;
					count++;
				}
			}
			
			for(int i = m - level - 2; i >= level + 1; i --) {
				if(head != null) {
					res[i][level] = head.val;
					head = head.next;
					count++;
				}else {
					res[i][level] = -1;
					count++;
				}
			}
			
		}
		
		return res;
    }
	public static void fillOuterLevel(int m, int n, int level, ListNode head) {
		
	}

}