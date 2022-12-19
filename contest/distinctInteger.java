import java.util.*;
public class distinctInteger {

	public static void main(String[] args) {
		int[] arr = {1,13,10,12,31};
		int res = countDistinctIntegers(arr);
		System.out.println(res);
	}
	
	public static int countDistinctIntegers(int[] nums) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int k: nums) {
			hs.add(k);
			StringBuilder sb = new StringBuilder(Integer.toString(k));
			sb.reverse();
			hs.add(Integer.parseInt(sb.toString()));
		}
		return hs.size();
    }

}
