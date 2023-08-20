
public class repeatCharacter {

	public static void main(String[] args) {
		String s = "abccbaacz";
		char res = repeatedCharacter(s);
		System.out.println(res);
	}
	
	public static char repeatedCharacter(String s) {
		int[] tbl = new int[26];
		char res = ' ';
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			tbl[c - 97] += 1;
			if(tbl[c - 97] == 2) {
				 res = c;
			}
		}
		return res;
    }

}
