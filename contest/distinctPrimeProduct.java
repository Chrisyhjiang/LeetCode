import java.util.*;
public class distinctPrimeProduct {
	
	public static int distinctPrimeFactors(int[] nums) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			int n = nums[i];
			boolean[] sieve = new boolean[n + 1];
			Arrays.fill(sieve, true);
			for(int j = 2; j <= n; j++) {
				if(sieve[j] && n % j == 0) {
					hs.add(j);
				}
				
				for(int k = j; k <= n; k+=j) {
					sieve[k] = false;
				}
			}
		}
        return hs.size();
    }
	
	
	public static void main(String[] args) {
		int[] arr = {2,4,8,16};
		int res = distinctPrimeFactors(arr);
		System.out.println(res);
	}
	

}
