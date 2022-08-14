import java.util.*;
public class SmallestNumberdI {

	public static void main(String[] args) {
		String pattern = "IIIDIDDD";
		String res = smallestNumber2(pattern);
		System.out.println(res);
	}
	
	public static String smallestNumber(String pattern) {
		boolean[] nums = new boolean[11];
		Arrays.fill(nums, true);
		// think of the string pattern as groups of Is and Ds
		char curChar = pattern.charAt(0);
		int pointer = 1;
		int count = 1;
		int[] res = new int[pattern.length() + 1];
		int resIndex = 0;
		while(pointer < pattern.length()) {
			if(pattern.charAt(pointer) != curChar) {
				if(curChar == 'I') {
					int k = getAvailable(nums, count);
					for(int i = 0; i < count; i++) {
						res[resIndex + i] = (k + i) ;
						nums[k+i] = false;
					}
					curChar = 'D';
					resIndex += count;
				}else {
					int k = getAvailable(nums, count+1);
					for(int i = 0; i < count + 1; i++) {
						res[resIndex + i] = (k + count - i);
						nums[k + count - i] = false;
					}
					curChar = 'I';
					resIndex += count+1;
				}
				
				count = 1;
			
			}else {
				count++;
			}
			pointer++;
		}
		String ans = "";
		for(int e: res) {
			ans += e;
		}
		return ans;
    }
	
	public static int getAvailable(boolean[] nums, int size) {

		int res = -1;
		for(int i = 1; i < nums.length - size; i++) {
			boolean flag = true;
			for(int j = i; j <= i + size; j++) {
				if(nums[j] == false) {
					flag = false;
					break;
				}
			}
			if(flag) {
				res = i;
				break;
			}
		}
		return res;
	}
	
	
	public static String smallestNumber2(String pattern) {
		int len = pattern.length();
		int [] res = new int[len+ 1];
		int left = -1;
		int right = -1;
		int count = 1;
		for(int i = 0; i < len; i++) {
			char c = pattern.charAt(i); 
			if(c == 'I') {
				res[i] = count++;
				if(left <= right) {
					for(int j = right; j > left; j--) {
						res[j] = count++;
					}
				}
				left = i;
			}else {
				right = i;
			}
		}
		if(right > left) {
			for(int i = len; i > left; i--) {
				res[i] = count++;
			}
		}else {
			res[len] = count;
		}
		String ans = "";
		for(int e: res) {
			ans += e;
		}
		return ans;
    }
}
