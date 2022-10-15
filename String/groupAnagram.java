import java.util.*;
public class groupAnagram {

	public static void main(String[] args) {
		

	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new LinkedList<List<String>>();
		HashMap<String, LinkedList<String>> hm = new HashMap<String, LinkedList<String>>();
		for(int i = 0; i < strs.length; i++) {
			String key = sort(strs[i]);
			if(hm.containsKey(key)) {
				LinkedList<String> ls = hm.get(key);
				ls.add(strs[i]);
				hm.put(key, ls);
			}else {
				LinkedList<String> ls = new LinkedList<String>();
				ls.add(strs[i]);
				hm.put(key, ls);
			}
		}
		for(String key: hm.keySet()) {
			res.add(hm.get(key));
		}
		return res;
    }
	
	public String sort(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

}
