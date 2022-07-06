import java.util.*;
public class DecodeMessage {
	
	public static void main(String[] args) {
		String key = "eljuxhpwnyrdgtqkviszcfmabo";
		String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
		
		String res = decodeMessage(key, message);
		System.out.println(res);
	}
	public static String decodeMessage(String key, String message) {
		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		String res = "";
		char start = 'a';
		hm.put(' ', ' ');
		for(int i = 0; i < key.length(); i++) {
			char entry = key.charAt(i);
			if(entry != ' ') {
				if(!hm.keySet().contains(entry)) {
					 hm.put(entry, start);
					 start ++;
				}
			}
			if(start > 'a' + 26) {
				break;
			}
			
		}
		
		for(int i = 0; i < message.length(); i ++) {
			res += hm.get(message.charAt(i));
		}
		
		return res;
		
    }
	
}
