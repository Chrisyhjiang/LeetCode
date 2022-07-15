// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
import java.util.*;
public class telephone {
	static Hashtable<Character, String> ht;
	public static void main(String[] args) {
		List<String> ls = letterCombinations2("23");
		for(String s: ls){
			System.out.println(s);
		}
	}
	public List<String> letterCombinations(String digits) {
		Hashtable<Character, String> ht = new Hashtable<Character, String>();
		ht.put('2', "abc");
		ht.put('3', "def");
		ht.put('4', "ghi");
		ht.put('5', "jkl");
		ht.put('6', "mno");
		ht.put('7', "pqrs");
		ht.put('8', "tuv");
		ht.put('9', "wxyz");
		
        List<String> ls = new ArrayList<String>();
        if(digits.length() == 0) {
        	return ls;
        }else if (digits.length() == 1) {
        	String tbl = ht.get(digits.charAt(0));
        	for(int i = 0; i < tbl.length(); i++) {
        		String s = "";
        		s += tbl.charAt(i);
        		ls.add(s);
        	}
        }else if (digits.length() == 2) {
        	String tbl1 = ht.get(digits.charAt(0));
        	String tbl2 = ht.get(digits.charAt(1));
        	
        	for(int i = 0; i < tbl1.length(); i++) {
        		for(int j = 0; j < tbl2.length(); j++) {
        			String s = "";
        			s += tbl1.charAt(i);
        			s += tbl2.charAt(j);
        			ls.add(s);
        		}
        	}
        }else if (digits.length() == 3) {
        	String tbl1 = ht.get(digits.charAt(0));
        	String tbl2 = ht.get(digits.charAt(1));
        	String tbl3 = ht.get(digits.charAt(2));
        	
        	for(int i = 0; i < tbl1.length(); i++) {
        		for(int j = 0; j < tbl2.length(); j++) {
        			for(int k = 0; k < tbl3.length(); k++) {
        				String s = "";
        				s += tbl1.charAt(i);
            			s += tbl2.charAt(j);
            			s += tbl3.charAt(k);
            			ls.add(s);
        			}
        		}
        	}
        	
        }else {
        	String tbl1 = ht.get(digits.charAt(0));
        	String tbl2 = ht.get(digits.charAt(1));
        	String tbl3 = ht.get(digits.charAt(2));
        	String tbl4 = ht.get(digits.charAt(3));
        	
        	for(int i = 0; i < tbl1.length(); i++) {
        		for(int j = 0; j < tbl2.length(); j++) {
        			for(int k = 0; k < tbl3.length(); k++) {
        				for(int l = 0; l < tbl4.length(); l++) {
        					String s = "";
        					s += tbl1.charAt(i);
                			s += tbl2.charAt(j);
                			s += tbl3.charAt(k);
                			s += tbl4.charAt(l);
                			ls.add(s);
        				}
        			}
        		}
        	}
        }
        return ls; 
    }

	public static List<String> letterCombinations2(String digits) {
		ht = new Hashtable<Character, String>();
		ht.put('2', "abc");
		ht.put('3', "def");
		ht.put('4', "ghi");
		ht.put('5', "jkl");
		ht.put('6', "mno");
		ht.put('7', "pqrs");
		ht.put('8', "tuv");
		ht.put('9', "wxyz");
		return populateList(digits, digits.length());
    }
	
	public static List<String> populateList(String digits, int n) {
		if(n == 0) {
			return new ArrayList<String>();
		}else if (n == 1) {
			String t = ht.get(digits.charAt(0));
			List<String> res = new ArrayList<String>();
			for(int i = 0; i < t.length(); i++) {
				res.add(Character.toString(t.charAt(i)));
			}
			return res;
		}else {
			List<String> a = populateList(digits,  n - 1);
			List<String> res = new ArrayList<String>();
			String s = ht.get(digits.charAt(n - 1));
			for(String e: a) {
				for(int i = 0; i < s.length(); i++) {
					res.add(e + Character.toString(s.charAt(i)));
				}
			}
			return res;
		}
	}
}
