import java.util.*;
public class PrefixofTwoArrays {
	
	public static int[] findThePrefixCommonArray(int[] A, int[] B) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int n = A.length;
		int[] res = new int[n];
		for(int i = 0; i < n; i++) {
			hm.put(A[i], i);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(hm.containsKey(B[j]) && hm.get(B[j]) <= i) {
					res[i]++;
				}
			}
		}
		return res;
		
    }
	
	public static void main(String[] args) {
		int[] A = {2,3,1};
		int[] B = {3,1,2};
		int[] res = findThePrefixCommonArray(A, B);
	}

}
