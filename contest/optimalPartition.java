import java.util.*;
public class optimalPartition {

	public static void main(String[] args) {
		String s = "ssssss";
		int res = partitionString(s);
		System.out.println(res);
	}
	
	public static int partitionString(String s) {
		int count = 0;
		HashSet<Integer> prev = new HashSet<Integer>();
		for(int i = 0; i < s.length(); i++) {
			int key = s.charAt(i) - 'a';
			if(prev.contains(key)) {
				count++;
				prev.clear();
				
			}
			prev.add(key);
		}
		if(prev.size() != 0) {
			count++;
		}
		return count;
    }

}
