// https://leetcode.com/problems/multiply-strings/
public class MultiplyString {

	public static void main(String[] args) {
		String s = multiply2("123", "456");
		System.out.println(s);
	}
	public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
        	return "0";
        }else {
        	int count = 1;
        	String first = multiplyby1Digit(num1, num2.charAt(num2.length() - 1));        	
        	for(int i = num2.length() - 2; i >= 0; i--) {
        		String cur = multiplyby1Digit(num1, num2.charAt(i));
        		first = add(first, cur, count);
        		count++;
        		
        	}
        	return first;
        }
    }
	
	public static String multiplyby1Digit(String num1, char num2) {
		String res = "";
		int carry = 0;
		for(int i = num1.length() - 1; i >= 0; i--) {
			char digit = num1.charAt(i);
			int val = (digit - '0') * (num2 - '0') + carry;
			carry = val / 10;
			res = Integer.toString(val % 10) + res;
		}
		if(carry != 0) {
			res = carry + res;
		}
		return res;
	}
	public static String add(String first, String second, int count) {
		String res = "";
		int carry = 0;
		for(int i = 0; i < count; i++) {
			res = first.charAt(first.length() - 1 - i) + res;
		}
		int firstIndex = first.length() - 1 - count;
		for(int i = second.length() - 1; i >= 0; i--) {
			if(firstIndex >= 0) {
				int value = (first.charAt(firstIndex) - '0') + (second.charAt(i) - '0') + carry;
				res = Integer.toString(value % 10) + res;
				carry = value / 10;
				firstIndex--;
			}else {
				int value = (second.charAt(i) - '0') + carry;
				res = Integer.toString(value % 10) + res;
				carry = value / 10;
			}
		}
		
		if(carry != 0) {
			res = carry + res;
		}
		return res;
	}
	
	public static String multiply2(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int l = num1.length();
		int m = num2.length();
		int[] ans = new int[l + m];
		for(int i = l - 1; i >= 0; i--) {
			for(int j = m - 1; j >= 0; j--) {
				int shift = (l - 1 - i) + (m - 1 - j);
				int val = ans[ans.length - 1 - shift] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				ans[ans.length - 1 - shift] = val % 10;
				ans[ans.length - 2 - shift] += val / 10;
			}
		}
		String res = "";
		if(ans[0] != 0) {
			res += ans[0];
		}
		for(int i = 1; i < ans.length; i++) {
			res += ans[i];
		}
		return res;
	}
}
