// https://leetcode.com/problems/reverse-words-in-a-string/submissions/
public class reverseWordsInString {

	public static void main(String[] args) {
		String s = "a good   example";
		String res = reverseWords(s);
		System.out.println(res);

	}
	static StringBuilder sb;
	public static String reverseWords(String s) {
        sb = new StringBuilder(s.trim());
        for(int i = 0; i < sb.length() / 2; i++) {
        	char head = sb.charAt(i);
        	int tail = sb.length() - 1 - i;
        	sb.setCharAt(i, sb.charAt(tail));
        	sb.setCharAt(tail, head);
        }
        
        int right = 0;
        int left = 0;
        while(right < sb.length()) {
        	if(sb.charAt(right) == ' ') {
        		reverse(left, right-1);
        		left = right + 1;
        		right++;
        	}else {
        		right++;
        	}
        }
        reverse(left, right-1);
        
        int start = 1;
        while(start < sb.length()) {
        	if(sb.charAt(start) == ' ') {
        		if(sb.charAt(start-1) == ' ') {
        			sb.deleteCharAt(start);
        			start--;
        		}
        	}
        	start++;
        }
        return sb.toString();
    }
	public static void reverse(int start, int end) {
		int length = (end - start + 1);
		for(int i = 0; i < length / 2; i++) {
			char head = sb.charAt(start + i);
			int tail = end - i;
			sb.setCharAt(start + i, sb.charAt(tail));
			sb.setCharAt(tail, head);
		}
	}
}
