// https://leetcode.com/problems/count-numbers-with-unique-digits/
import java.util.*;
public class countNumberUniqueDigits {

	public static void main(String[] args) {
		int res = countNumbersWithUniqueDigits(4);
		System.out.println(res);
	}
	
	public static int countNumbersWithUniqueDigits(int n) {
		// basic combinatorics of unique digits. 
		// 1st digit is 9, 2nd digit is also 9, third is 8, 4th is 7
		if(n == 0) {
			return 1;
		}else if(n == 1){
			return 10;
		}else {
			// row 0 are the numbers that have no duplicate digits. 
			// row 1 are the numbers that have duplicate numbers.
			// numbers from the smaller digits are already calculated. 
			int[] DP = new int[n+1];
			DP[0] = 1;
			DP[1] = 9;
			int cur = 9;
			for(int i = 2; i <= n; i++) {
				cur *= (9 - i + 2);
				DP[i] = cur;
			}
			int res = 0;
			
			for(int e: DP) {
				res += e;
			}
			return res;
		}
    }

}
