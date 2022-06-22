import java.util.*;
// https://leetcode.com/problems/roman-to-integer/
public class RomanNumeralToInt {
	public static int romanToInt(String s) {
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        ht.put('I', 1);
        ht.put('V', 5);
        ht.put('X', 10);
        ht.put('L', 50);
        ht.put('C', 100);
        ht.put('D', 500);
        ht.put('M', 1000);
        
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
        	char digit = s.charAt(i);
        	if(i < s.length() - 1) {
        		char nextDigit = s.charAt(i+1);
        		if(digit == 'I') {
        			if(nextDigit == 'V'){
        				result += 4;
        				i++;
        			}else if (nextDigit == 'X') {
        				result += 9;
        				i++;
        			}else {
        				result += 1;
        			}
        		}else if (digit == 'X') {
        			if(nextDigit == 'L'){
        				result += 40;
        				i++;
        			}else if (nextDigit == 'C') {
        				result += 90;
        				i++;
        			}else {
        				result += 10;
        			}
        		}else if (digit == 'C') {
        			if(nextDigit == 'D'){
        				result += 400;
        				i++;
        			}else if (nextDigit == 'M') {
        				result += 900;
        				i++;
        			}else {
        				result += 100;
        			}
        		}
        		else {
        			result += ht.get(digit);
        		}
        	}else {
        		result += ht.get(digit);
        	}
        	
        }
        return result;
        
    }
	public static void main(String[] args) {
		int n = romanToInt("CDXLIX");
		System.out.println(n);
	}

}
