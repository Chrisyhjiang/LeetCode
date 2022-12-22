
public class countBits {

	public static void main(String[] args) {


	}
	
	public int[] countBits(int n) {
		// use DP to cache the answer. we have the data for n / 2 
		// so we just have to check if it is divisible. 
		int[] res = new int[n+1];
		res[0] = 0;
		for(int i = 1; i <= n; i++) {
			if(i % 2 == 0) {
				res[i] = res[i / 2];
			}else {
				res[i] = res[i / 2] + 1;
			}
		}
		
        return res;
    }
	
}
