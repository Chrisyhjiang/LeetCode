import java.util.*;
public class removeStars {

	public static void main(String[] args) {
		String s = "erase*****";
		String ans = removeStars(s);
		System.out.println(ans);
	}
	public static String removeStars(String s) {
		Stack<Character> st = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			st.push(s.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while(!st.isEmpty()) {
			char c = st.pop();
			if(c == '*') {
				count ++;
			}else {
				if(count != 0) {
					count--;
				}else {
					sb.insert(0, c);
				}
			}
		}
		return sb.toString();
    }

}
