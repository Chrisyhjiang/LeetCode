// https://leetcode.com/problems/unique-binary-search-trees/
import java.util.*;

public class UniqueBinaryTree {

	public static void main(String[] args) {
		int k = numTrees(4);
		System.out.println(k);
	}
	
	public static int numTrees(int n) {
		if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 2;
		}else {
			int[] arr = new int[2];
			arr[0] = 1;
			arr[1] = 1;
			int step = 2;
			while(step < n) {
				int[] temp = arr;
				arr = new int[temp.length + 1];
				for(int i = 0; i < temp.length; i++) {
					for(int j = 0; j <= i + 1; j++) {
						arr[j] += temp[i];
					}
				}
				step++;
			}
			
			int sum = 0;
			for(int e: arr) {
				sum += e;
			}
			return sum;
		}
    }

}
