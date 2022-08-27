// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
import java.util.*;
public class kthSmallestInMatrix {

	public static void main(String[] args) {
		int[][] mat = {{-5,-4},{-5,-4}};
		int ans = kthSmallest2(mat, 2);
		System.out.println(ans);
	}
	public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        if(matrix.length == 1) {
        	return matrix[0][0];
        }
        int len = matrix.length;
        int size = len * len + 1 - k;
        for(int[] row: matrix) {
        	for(int e: row) {
        		if(pq.size() >= size) {
        			pq.poll();
        		}
        		pq.add(e);        		
        	}
        }
        return pq.poll();
    }
	
	public static int kthSmallest2(int[][] matrix, int k) {
		
		// since the kth largest has to belong in between the first and last elemen
		// of the matrix, we can use binary search. 
		int min = matrix[0][0];
		int max = matrix[matrix.length - 1][matrix.length - 1];
		
		while(min != max) {
			int mid = min + (max - min) / 2;
			int count = countLessThanOrEqual(matrix, mid);
			// if the numbers lest than or equal to the mid is less t
			if(count < k) {
				min = mid + 1;
			}else {
				max = mid;
			}
		}
		return min;
	}
	
	public static int countLessThanOrEqual(int[][] matrix, int target) {
		int count = 0;
		int row = 0;
		int col = matrix.length - 1;
		
		while(row < matrix.length && col >= 0) {
			if(matrix[row][col] <= target) {
				count += col + 1;
				row++;
			}else {
				col --;
			}
		}
		
		return count;
		
		
	}
}
