
public class sumNoAddition {

	public static void main(String[] args) {
		int res = getSum(2,3);
		System.out.println(res);

	}
	
	public static int getSum(int a, int b) {
		if(b == 0) {
			return a;
		}else {
			return getSum(a ^ b, (a & b) << 1);
		}	
	}
	
}
