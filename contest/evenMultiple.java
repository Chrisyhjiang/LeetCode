
public class evenMultiple {

	public static void main(String[] args) {
		int res = smallestEvenMultiple(5);
		System.out.println(res);
	}
	
	public static int smallestEvenMultiple(int n) {
		int end = 2 * n;
		int res = 0;
		for(int i = Math.max(2, n); i <= end; i++) {
			if(i % 2 == 0 && i % n == 0) {
				res = i;
				break;
			}
		}
		return res;
    }
}
