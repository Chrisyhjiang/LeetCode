import java.util.Arrays;

public class fillCups {

	public static void main(String[] args) {
		int[] arr = {2,2,2};
		int n =  fillCups(arr);
		System.out.println(n);

	}
	public static int fillCups(int[] amount) {
		
		Arrays.sort(amount);
		int count = amount[0] + amount[1] + amount[2];
		int res = 0;
		while(count > 0) {
			if(amount[1] > 0 ) {
				amount[1]--;
				count--;
			}
			if (amount[2] > 0) {
				amount[2]--;
				count--;
			}
			res++;
			Arrays.sort(amount);
		}
		
		return res;
		
    }
	public static int fillCups2(int[] amount) {
		int[] temp = amount;
        Arrays.sort(temp);
        int a = temp[0];
        int b = temp[1];
        int c = temp[2];
		int res = 0;
		while(a != 0 || b != 0 || c != 0) {
			if (a > 2 && b > 2 && c > 2) {
				res += 3;
				a -= 2;
				b -= 2;
				c -= 2;
				continue;
			}
			if(c >= a + b) {
				res += c;
				a = 0;
				b = 0;
			}else {
				if (a == 1 && b == 1 && c == 1) {
					res += 2;
					a = 0;
					b = 0;
					c = 0;
					continue;
				}
				if(c == 2 && b == 2 && a == 1) {
					res += 2;
					a = 0;
					b = 0;
					c = 0;
					continue;
				}
			}
		}
		return res;
    }
}
