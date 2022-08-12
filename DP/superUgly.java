import java.util.ArrayList;
import java.util.*;

// https://leetcode.com/problems/super-ugly-number/
public class superUgly {

	public static void main(String[] args) {
		int[] primes = {2,3,5,7};
		int n = 5911;
		long res = nthSuperUglyNumber(n, primes);
		System.out.println(res);
	}
	public static long nthSuperUglyNumber(int n, int[] primes) {
        long[] DP = new long[n];
        DP[0] = 1;
        HashMap<Integer, Integer> pointers = new HashMap<Integer, Integer>();
        for(int p: primes) {
        	pointers.put(p, 0);
        }
        ArrayList<Integer> minIndex = new ArrayList<Integer>();
        for(int i = 1; i < n; i++) {
        	long min = Integer.MAX_VALUE;
        	for(int prime: primes) {
        		long cur = prime * DP[pointers.get(prime)];
        		if(cur < min) {
        			for(int e: minIndex) {
        				pointers.put(e, pointers.get(e)-1);
        			}
        			minIndex.clear();
        			minIndex.add(prime);
        			pointers.put(prime, pointers.get(prime) + 1);
        			min = cur;
        		}else if (cur == min) {
        			pointers.put(prime, pointers.get(prime) + 1);
        			minIndex.add(prime);
        		}
        	}
        	DP[i] = min;
        	minIndex.clear();
        }
        return (int)DP[n-1];
    }

}
