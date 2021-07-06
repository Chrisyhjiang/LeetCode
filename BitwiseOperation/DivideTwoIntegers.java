// https://leetcode.com/problems/divide-two-integers/

// # 29
public class DivideTwoIntegers {

	public static void main(String[] args) {
		
		int num = divide(-2147483648,-1);
		
		System.out.println(num);
		
	}
	
	public static int divide(int dividend, int divisor) {
		// to check for corner cases of Integer = minmum value, per stated in the question. 
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		// have to convert to long before taking absolute value. Convert to absolute value before dividing
		long cDividend = Math.abs((long) dividend);
		long cDivisor = Math.abs((long) divisor);
	
		int total = 0;
		
		while (cDividend >= cDivisor) {
			
			// check only for powers of diviso * increasingly larger powers of 2. 
			int i = 0;
			
			// 3 * 2^0, 3* 2^1 ... until it becomes larger than dividend 
			while (cDividend >= cDivisor << i) {
				i++;
			}
			// increment total by the appropriate #
			total += 1<< (i-1);
			// subtract dividend from appropriate number 
			cDividend -= cDivisor << (i-1); 
		}
		// negate total when appropriate
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			total = ~total +1;
		}
		
		return total;
	}

}
