
public class abp {

	public static void main(String[] args) {
		long ans = calculate(2,4,15);
		System.out.println(ans);
	}
	
	public static long calculate(int a, int b, int p) {
		if(b == 0) {
			return 1;
		}
		if(b == 1) {
			return a;
		}
		long res = 1;
		
		res = calculate(a, b / 2, p) % p;
		res = res * res % p;
		if(b % 2 == 1) {
			res =res * a % p;
		}
		return res % p;
		
	}

}
