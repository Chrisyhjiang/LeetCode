import java.util.HashMap;

public class sumToN {
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		int n = 1 << 2;
		System.out.println(n);
				

	}
	
	public int getSumToN(int n) {
		hm.put(0, 0);
		return (n + square(n)) >> 1;
	}
	
	public int square(int n) {
		int last  = n % 2;
		int temp = n << 1;
		
	}

}
