
public class findOGXor {

	public static void main(String[] args) {
		int[] arr = {5,2,0,3,1};
		int[] res = findArray(arr);
		for(int e: res) {
			System.out.println(e + " ");
		}
		
	}
	
	public static int[] findArray(int[] pref) {
		int n = pref.length;
		int[] res = new int[n];
		res[0] = pref[0];
		
		for(int i = 1; i < n; i++) {
			res[i] = pref[i-1] ^ pref[i];
		}
		
		return res;
		
    }

}
