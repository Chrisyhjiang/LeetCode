// https://leetcode.com/problems/gray-code/
import java.util.*;
public class GrayCode {
	static List<Integer> res;
	public static void main(String[] args) {
		List<Integer> gray = grayCode(2);
		for(int e: gray) {
			System.out.println(e);
		}
	}
	
	public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
		if(n == 1) {
			res.add(0);
			res.add(1);
		}else {
			List<String> binary = new ArrayList<String>();
			binary.add("0");
			binary.add("1");
			for(int i = 1; i < n; i++) {
				ArrayList<String> newBinary = new ArrayList<String>();
				for(int j = 0; j < binary.size(); j++) {
					newBinary.add("0"+binary.get(j));
					newBinary.add("1"+binary.get(binary.size() - 1 - j));
				}
				binary = newBinary;
			}
			for(int i = 0; i < binary.size(); i++) {
				res.add(Integer.parseInt(binary.get(i), 2));
			}
		}
		return res;
    }
	
	public static List<Integer> grayCode2(int n){
		// the way to arrive at the gray code is to add 0 to all the numbers, then 
		// reverse the list and then add 1 to all the numbers in the lsit.  
		List<Integer> res = new ArrayList<Integer>();
		res.add(0);
		for(int i = 1; i <= n; i++) {
			// the mask means adding 1 in the most significant bit.
			int mask = 1 << (i-1);
			for(int j = res.size() - 1; j >=0; j--) {
				// adding a 0 in the first place changes nothing
				// thus we loop back and add 1
				res.add(mask + res.get(j));
			}
		}
		return res;
	}
	
	
}
