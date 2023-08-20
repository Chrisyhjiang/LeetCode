
public class countDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int countDigits(int num) {
		int temp = num;
		int count = 0;
		while(temp > 0) {
			int cur = temp % 10;
			count += (num % cur == 0) ? 1 : 0;
			temp /= 10;
		}
		return count;
    }



}
