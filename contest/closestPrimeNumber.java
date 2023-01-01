import java.util.*;

public class closestPrimeNumber {
	
	public static int[] closestPrimes(int left, int right) {
		ArrayList<Integer> ls = getPrimes(left, right, new ArrayList<Integer>());
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		if(ls.size() <= 1) {
			return res; 
		}
		res[0] = left - 1;
		res[1] = right + 1;
		for(int i = 1; i < ls.size(); i++) {
			 if(ls.get(i) - ls.get(i - 1) < res[1] - res[0]) {
				 res[1] = ls.get(i);
				 res[0] = ls.get(i - 1);
			 }
		}
		return res;
    }
	
	public static ArrayList<Integer> getPrimes(int l, int r, ArrayList<Integer> ls) {
		boolean[] sieve = new boolean[r + 1];
		Arrays.fill(sieve, true);
		for(int i = 2; i <= r; i++) {
			if(sieve[i] && i >= l) {
				ls.add(i);
			}
			for(int j = i; j <= r; j+=i) {
				sieve[j] = false;
			}
		}
		return ls;
	}
	
	public static void main(String[] args) {
		int left = 4;
		int right = 6;
		int[] ans = closestPrimes(left, right);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}
}
