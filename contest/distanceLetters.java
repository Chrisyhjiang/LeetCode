import java.util.*;
public class distanceLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean checkDistances(String s, int[] distance) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			char key = s.charAt(i);
			if(hm.containsKey(key)) {
				int num = i - hm.get(key) - 1;
				hm.put(key, num);
			}else {
				hm.put(key, i);
			}
		}
		
		for(Character c: hm.keySet()) {
			if(!(distance[c - 'a'] == hm.get(c))) {
				return false;
			}
		}
		return true;
    }

}
