// https://leetcode.com/problems/remove-duplicate-letters/
import java.util.*;
public class removeDuplicateLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String removeDuplicateLetters(String s) {
		// this a greedy / stack problem
		HashMap<Character, Integer> last = new HashMap<Character, Integer>();
		Stack<Character> st = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			last.put(s.charAt(i), i);
		}
		HashSet<Character> hs = new HashSet<Character>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// if the character is not already in the stack. 
			if(!hs.contains(c)) {
				// if the cur char is smaller than the top on the stack and the top of the stack is not the last occurence. 
				// there is going to be a better solution down the line, so we remove the current highest element in the stack. 
				while(!st.isEmpty() && c < st.peek() && last.get(st.peek()) > i) {
					// remove the character from the stack once it is used. 
					hs.remove(st.pop());
				}
				// add to the stack and add to the seen pile. 
				hs.add(c);
				st.push(c);
			}
		}
		StringBuilder sb = new StringBuilder(st.size());
		for(Character c: st) {
			sb.append(c.charValue());
		}
		return sb.toString();
    }

}
