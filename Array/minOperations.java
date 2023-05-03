
public class minOperations {

	public static void main(String[] args) {
		int x = gcd(15, 25);
		System.out.println(x);
	}
	
	public int minOperations(int[] nums) {
		int ones = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {	
			if (nums[i] == 1) {
				ones ++;
			}
		}
		
		if(ones > 0) {
			// if the array contains ones, we do not need to include. 
			return n - ones;
		} else {
			int res = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++) {
				int d = nums[i];
				// loop through to check as soon as one gcd is one, we ca find an answer. 
				for(int j = i + 1; j < n; j++) {
					d = gcd(d, nums[j]);
					if(d == 1) {
						// j - i represents the number of steps needed to turn one of the numbers into 1. 
						res = Math.min(res, j - i);
						break;
					}
				}
				if (d != 1) {
					break;
				}
			}
			if(res == Integer.MAX_VALUE) {
				return -1;
			} else {
				return n - 1 + res;
			}
		}
    }
	
	public static int gcd(int a, int b) {
		if(a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}


}
