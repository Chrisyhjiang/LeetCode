// https://leetcode.com/problems/count-primes/submissions/
import java.util.*;
public class primes {

	public static void main(String[] args) {
		int k = countPrimes(10);
		System.out.println(k);
	}
	
	public static int countPrimes(int n) {
		if(n == 0|| n == 1 || n == 2) {
			return 0;
		}
		boolean[] arr = new boolean[n];
		Arrays.fill(arr, true);
		arr[1] = false;
		
		for(int i = 4; i < n; i+=2) {
			arr[i] = false;
		}
		int total = 0;
		for(int i = 2; i * i < n; i++) {
			if(!arr[i]) {
				continue;
			}
			arr[i] = true;
			for(int j = i * i; j < n; j += i) {
				arr[j] = false;
			}
		}
		// finds total
		for(int i = 1; i < n; i++) {
			if(arr[i]) {
				total++;
			}
		}
		
		return total;
    }
	
}
