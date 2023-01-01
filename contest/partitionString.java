import java.util.Arrays;

public class partitionString {

	public static void main(String[] args) {
		String s = "060";
		int k = 60;
		int res = minimumPartition(s, k);
		System.out.println(res);

	}
	
	public static int minimumPartition(String s, int k) {
		char[] arr = s.toCharArray();
		int n = arr.length;
		if(!doable(arr, k)) {
			return -1;
		}
		int count = 0;
		int i = 0;
		while(i < n) {
			long cur = 0;
			int shift = 0;
			for(int j = i; j < n; j++) {
				cur = cur * 10 + arr[j] - '0';
				if(cur > k) {
					break;
				}else {
					shift++;
				}
			}
			count ++;
			if(i == n - 1) {
				break;
			}
			i += shift;
		}
		return count;
    }
	
	public static boolean doable(char[] arr, int num) {
		for(int a: arr) {
			if((a-'0') > num) {
				return false;
			}
		}
		return true;
	}

}
