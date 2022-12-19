import java.util.*;
public class toRecurringDecimal {

	public static void main(String[] args) {
		String ans = fractionToDecimal(1, 2);
		System.out.println(ans);
	}
	
	public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
        	return "0";
        }else {
        	StringBuilder res = new StringBuilder();
        	if (numerator < 0 ^ denominator < 0) {
        		res.append("-");
        	}
        	// long cast to remove overflow errors. 
        	long n = Math.abs((long) numerator);
        	long d =  Math.abs((long) denominator);
        	// makes sure remainder is always strictly smaller. 
        	res.append(Long.toString(n / d));
        	long remainder = n % d;
        	// hash map tracks remainder and its position in the sb. 
        	HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
        	if(remainder == 0) {
        		return res.toString();
        	}else {
        		res.append(".");
        		while(remainder != 0) {
        			if(hm.containsKey(remainder)) {
        				res.insert(hm.get(remainder), "(");
        				res.append(")");
        				break;
        			}
        			// by inserting the length, it can tell us the index to mark the repeat. 
        			hm.put(remainder, res.length());
        			remainder *= 10;
        			res.append(Long.toString(remainder / d));
        			remainder %= d;
        		}
        	}
        	return res.toString();
        }
    }
	
	

}
