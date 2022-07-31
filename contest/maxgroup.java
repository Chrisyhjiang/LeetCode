import java.util.*;
public class maxgroup {

	public static void main(String[] args) {
		int[] grades = {47,2,16,17,41,4,38,23,47};
		int res = maximumGroups(grades);
		System.out.println(res);
	}
	
	public static int maximumGroups(int[] grades) {
		int len = grades.length;
		if(len == 1 || len == 2) {
			return 1;
		}else {
			int k = (int) Math.sqrt(2 * (double) len);
			if(k * (k + 1) / 2 > len) {
				return k -1;
			}else {
				return k;
			}
		}
    }

}
