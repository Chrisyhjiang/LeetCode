
public class beautifulInteger {

	public static void main(String[] args) {
		String s = "6068060761";
		long res = makeIntegerBeautiful(Long.parseLong(s), 3);
		System.out.println(res);
	}
	
	public static int sum(long n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    public static long makeIntegerBeautiful(long n, int target) {
    	// shift the digit to the left and evaluate the sum add one to ensure always biggerdont consider rest as they are 0. 
        long k = n;
        long pow10 = 1;
        while (sum(n) > target) {
            n = n / 10 + 1;
            pow10 *= 10;
        }
        // n is the first digit
        return n * pow10 - k;
    }
}
