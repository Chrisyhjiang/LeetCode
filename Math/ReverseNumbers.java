
public class ReverseNumbers {
	public static int reverse(int x) {
        long rev = 0;
        int temp = Math.abs(x);
        while(temp > 0){
            int digit = temp % 10;
            temp /= 10;
            rev = rev * 10 + digit;
            if(rev > Integer.MAX_VALUE){
                rev = 0;
                break;
            }
        }
        int res = (int) rev;
       
        if (x > 0){
            return res;
        }else{
            return -1 * res;
        }
    }
	public static void main(String[] args) {
		int n = reverse(123);
		System.out.println(n);

	}

}
