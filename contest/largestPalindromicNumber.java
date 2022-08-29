import java.util.*;
public class largestPalindromicNumber {

	public static void main(String[] args) {
		String num = "00000";
		String ans = largestPalindromic(num);
		System.out.println(ans);

	}
	
	public static String largestPalindromic(String num) {
		StringBuilder left = new StringBuilder();
		StringBuilder right = new StringBuilder();
		int[] arr = new int[10];
		for(int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			arr[c - '0'] ++;
		}
		int mid = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				String index = String.valueOf(i);
				left.insert(0, index.repeat(arr[i] / 2));
				right.append(index.repeat(arr[i] / 2));
				if(arr[i] % 2 == 1) {
					mid = i;
				}
			}
		}
		
		String l = left.toString();
		String r = right.toString();
		String m = String.valueOf(mid);
		if(l.length() > 0 && l.charAt(0) == '0') {
			l = "";
			r = "";
			if(mid == -1) {
				m = "0";
			}
		}else {
			if(mid == -1) {
				m = "";
			}
		}
		
		return l + m + r;
		
    }

}
