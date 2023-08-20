import java.math.BigInteger;

public class smallestValPrime {

	public static void main(String[] args) {
		
		
	}
	
	public static int smallestValue(int n) {
		if(n == 0 || n == 1 || isPrime(n)) {
			return n;
		}else {
			int sumOfPrime = spf(n);
			if(n <= sumOfPrime) {
				return sumOfPrime;
			}else {
				return smallestValue(sumOfPrime);
			}
		}
    }

	public static boolean isPrime(int p) {
		for(int i = 2; i < Math.floor(Math.sqrt(p)) + 1; i++){
			if(p % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int spf(int cur) {
		int res = 0;
		int p = 2;
		while(cur > 1) {
			if(isPrime(p) && cur % p == 0) {
				res += p;
				cur /= p;
			}else {
				p++;
			}
		}
		return res;
	}
}
