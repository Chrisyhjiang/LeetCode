// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
import java.util.*;
public class longestSubstring2DistinctAtMost {

	public static void main(String[] args) {
		String s = "ccaabbb";
		int res = lengthOfLongestSubstringTwoDistinct(s);
		System.out.println(res);
	}
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
	    int n = s.length();
	    if (n < 3) {
	    	return n;
	    }
	    int left = 0;
	    int right = 0;
	    HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
	    int maxLength = 2;
	    // hashmap to characcter and index on the right;
	    while (right < n) {
	      hm.put(s.charAt(right), right+1);
	      if(hm.size() > 2) {
	    	  int min = Collections.min(hm.values());
	    	  hm.remove(s.charAt(min));
	    	  left = min + 1;
	      }
	      maxLength = Math.max(maxLength, right - left);
	      right++;
	    }
	    return maxLength;
	  }
	
}
