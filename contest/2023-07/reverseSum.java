
public class reverseSum {

	public static void main(String[] args) {
		boolean ans = sumOfNumberAndReverse(11111);
		System.out.println(ans);
	}
	
	public static boolean sumOfNumberAndReverse(int num) {
		int length = Integer.toString(num).length() - 2;
		int start = (int) Math.pow(10, length);
		for(int i = start; i <= num; i++) {
			if(i + reverse(i) == num) {
				return true;
			}
		}
		return false;
    }
	
	public static int reverse(int s) {
		int res = 0;
		while(s > 0) {
			res = res * 10 + s % 10;
			s/= 10;
		}
		return res;
	}

}
