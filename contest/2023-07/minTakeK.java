import java.util.*;
public class minTakeK {
	
	
	public static void main(String[] args) {
		String s = "abc";
		int k = 1;
		System.out.println(takeCharacters(s, k));
	}
	// sliding windown for each window but inverted/.  
	public static int takeCharacters(String s, int k) {
		int n = s.length();
		int j = 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int res = n + 1;
		int window = 0;
		for(int i = 0; i < n; i++) {
			if(hm.containsKey(s.charAt(i))) {
				hm.replace(s.charAt(i), hm.get(s.charAt(i)) + 1);
			}else {
				hm.put(s.charAt(i),1);
			}
		}
		// check if the answer exists. 
		if(hm.getOrDefault('a', 0) < k || hm.getOrDefault('b', 0) < k || hm.getOrDefault('c', 0) < k){
			return -1;
		}
		
		for(int i = 0; i < n; i++) {
			char cur = s.charAt(i);
			hm.put(cur, hm.get(cur) - 1);
			window++;
			while(hm.get(cur)<k){
				 hm.put(s.charAt(j), hm.get(s.charAt(i)) + 1);
	                window--;
	                j++;
	       }
			res = Math.min(res, n - window);
		}
		return res;
		
    }
	
	 
	
}
