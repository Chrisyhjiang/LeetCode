import java.util.*;
public class similarStr {

	public static void main(String[] args) {
		String[] arr = {"aabb","ab","ba"};
		
		int res = similarPairs(arr);
		System.out.println(res);

	}
	
	public static int similarPairs(String[] words) {
		int res = 0;
		
		for(int i = 0; i < words.length - 1; i++) {
			for(int j = i+1; j < words.length; j++) {
				if(isSimilar(words[i], words[j]) && isSimilar(words[j], words[i])) {
					res++;
				}
			}
		}
		return res;
    }
	
	public static boolean isSimilar(String s1, String s2) {
		HashSet<Character> hs = new HashSet<Character>();
		for(int i = 0; i < s1.length(); i++) {
			hs.add(s1.charAt(i));
		}
		for(int i = 0; i < s2.length(); i++) {
			if(!hs.contains(s2.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
