// https://leetcode.com/problems/word-break/
import java.util.*;
public class WordBreak {
	static HashMap<String, Boolean> DP;
	public static void main(String[] args) {
		String s = "abcd";
		List<String> ls = new ArrayList<String>();
		ls.add("a");
		ls.add("abc");
		ls.add("b");
		ls.add("cd");
		boolean res = wordBreak2(s, ls);
		System.out.println(res);
	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<String>();
        for(String word: wordDict) {
        	dict.add(word);
        }
        DP = new HashMap<String, Boolean>();
        return contains(s, dict);
    }
	
	public static boolean contains(String s, HashSet<String> dict) {
		if(s.length() == 0) {
			return true;
		}else {
			boolean res = false;
			String word = "";
			for(int i = 0; i < s.length(); i++) {
				word += s.charAt(i);
				if(dict.contains(word)) {
					String next = s.substring(i + 1);
					if(DP.containsKey(next)) {
						res = DP.get(next);
					}else {
						boolean b = contains(next, dict);
						DP.put(next, b);
						res = res || b;
					}
				}
			}
			return res;
		}
	}



	public static boolean wordBreak2(String s, List<String> wordDict) {
		int n = s.length();
		// padding true DP array to track the status up to that point.
		boolean[] DP = new boolean[n + 1];
		DP[n] = true;
		
		for(int i = n - 1; i >= 0; i--) {
			for(String word: wordDict) {
				int k = i + word.length();
				if(k <= n) {
					String sub = s.substring(i, k);
					if(sub.equals(word)) {
						DP[i] = DP[k];
						// prevents overwriting the value
						if(DP[i]) {
							break;
						}
					}
				}
				
			}
		}
		
		return DP[0];
	}
}
