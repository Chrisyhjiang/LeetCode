
public class trailingZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int trailingZeroes(int n) {
		int res = 0;
		while(n > 0) {
			res += n /= 5;
		}
		return res;
    }


}
