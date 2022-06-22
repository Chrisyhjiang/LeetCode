// https://leetcode.com/problems/integer-to-roman/
import java.util.*;
public class IntToRomanNumeral {
	
	public static String intToRoman1(int num) {
		// use hardcode value + logic to solve the problem. 
        String res = "";
        int[] arr = new int[1001];
        int thousands = num / 1000;
        num %= 1000;
        
        for(int i = 0; i < thousands; i++) {
        	res += "M";
        }
        
        int hundreds = num / 100;
        num %= 100;
        if(hundreds == 4) {
        	res += "CD";
        }else if (hundreds == 9) {
        	res += "CM"; 
        }else {
        	if(hundreds < 5) {
        		for(int i = 0; i < hundreds; i++) {
            		res += "C";
            	}
        	}else if (hundreds == 5) {
            	res += "D";
        	}else {
        		res += "D";
        		for(int i = 0; i < hundreds - 5; i++) {
        			res += "C";
        		}
        	}
        }
        
        int tens = num / 10;
        num %= 10;
        if(tens == 4) {
        	res += "XL";
        }else if (tens == 9) {
        	res += "XC"; 
        }else {
        	if(tens < 5) {
        		for(int i = 0; i < tens; i++) {
            		res += "X";
            	}
        	}else if (tens == 5) {
            	res += "L";
        	}else {
        		res += "L";
        		for(int i = 0; i < tens - 5; i++) {
        			res += "X";
        		}
        	}
        }
        
        // num is single digit now
        if(num == 4) {
        	res += "IV";
        }else if (num == 9) {
        	res += "IX";
        }else {
        	if(num < 5) {
        		for(int i = 0; i < num; i++) {
        			res += "I";
        		}
        	}else if (num == 5) {
        		res += "V";
        	}else {
        		res += "V";
        		for(int i = 0; i < num - 5; i++) {
        			res += "I";
        		}
        	}
        }
        
        return res;
    }
	
	public static String intToRoman2(int num) {
		// using greedy, as long as there is a larger value, ew use the largest value. 
		String res = "";
		int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] letters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};;
		
		for(int i = 0; i < arr.length && num > 0; i++) {
			while(num >= arr[i]) {
				num -= arr[i];
				res += letters[i];
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = intToRoman2(1400);
		System.out.println(s);
	}

}
