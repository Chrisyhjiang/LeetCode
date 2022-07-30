// https://leetcode.com/problems/ugly-number-ii/
public class uglyNumber {

	public static void main(String[] args) {
		int k = nthUglyNumber(7);
		System.out.println(k);
	}
	public static int nthUglyNumber(int n) {
        if(n == 1) {
        	return 1;
        }else{
        	int[] DP = new int[n];
        	DP[0] = 1;
        	int two = 0;
        	int three = 0;
        	int five = 0;
        	
        	for(int i = 1; i < DP.length; i++) {
        		DP[i] = Math.min(2 * DP[two], Math.min(3 * DP[three], 5 * DP[five]));
        		int second = 2 * DP[two];
        		int third = 3 * DP[three];
        		int fifth = 5 * DP[five];
        		if(DP[i] == second && second == third && third == fifth) {
        			two++;
        			three++;
        			five++;
        		}else if(DP[i] == second && second == third) {
        			two++;
        			three++;
        		}else if(DP[i] == second && second == fifth) {
        			two++;
        			five++;
        		}else if (DP[i] == third && third == fifth){
        			three++;
        			five++;
        		}else if(DP[i] == second) {
        			two++;
        		}else if (DP[i] == third) {
        			three++;
        		}else {
        			five++;
        		}
        	}
        	return DP[DP.length - 1];
        	
        }
		
        
    }
	
	public static boolean isUgly(int n) {
		while(n % 2 == 0) {
			n /= 2;
		}
		while(n % 3 == 0) {
			n /= 3;
		}
		while(n % 5 == 0) {
			n /= 5;
		}
		if(n == 1) {
			return true;
		}else {
			return false;
		}
	}
}
